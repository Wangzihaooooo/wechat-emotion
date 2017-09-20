# -*- coding: utf-8 -*-
import urllib
import scrapy
import json
import urllib2
import os

from scrapy import FormRequest
from scrapy.utils.project import get_project_settings
from music.items import MusicItem

class MusicspiderSpider(scrapy.Spider):
    name = 'musicSpider'
    tagDict={
        '轻松':0,'舒服':0,'轻音乐':0,
        '励志':1,'美好':1,'美好':1,
        '激情':2, '劲爆':2,
        '寂寞':3,'想念':3,'伤感':3,'深情':3
    }
    baseUrl = 'http://music.baidu.com/tag/%s?start=%s&size=20&third_type=0'
    basepage=0
    size=20
    allPages=100
    not_found_list = []

    def start_requests(self):
        print('start crawling musicSpider...')
        for tag in self.tagDict:
            url = self.baseUrl % (tag, self.basepage * self.size)
            yield scrapy.Request(url, callback=self.list_parse, dont_filter=True,meta={'tag': tag,'page':self.basepage})

    def list_parse(self, response):
        self.allPages=1
        #self.allPages=int(response.xpath('//div[@class="page-inner"]/a//text()').extract()[-2])#需注意获取的是string，要转化为int
        songList=response.xpath('//div[@class="search-song-list song-list song-list-hook"]/ul/li/div[@class="song-item clearfix "]')
        for result in songList:
            item = MusicItem()
            try:
                if(result.xpath('./span[@class="song-title"]/a/@class').extract()[0]=="no-link"):
                     return
                else:
                    item['song_tag'] = self.tagDict[response.meta["tag"]]
                    item['song_id'] = result.xpath('./span[@class="song-title"]/a/@href').extract()[0].replace("/song/", "")
                    item['song_title'] = result.xpath('./span[@class="song-title"]//text()').extract()[0]
                    item['singer_name'] = result.xpath('./span[@class="singer"]/span[@class="author_list"]/@title').extract()[0]
                    try:
                        item['album_title'] = result.xpath('./span[@class="album-title"]/a/text()').extract()[0]
                    except:
                        item['album_title'] = None

                    song_url = "http://music.baidu.com/data/music/songlink"
                    yield FormRequest(url=song_url,
                                      formdata={'songIds': item['song_id'], 'type': 'mp3'},
                                      dont_filter=True,
                                      meta={'item': item},
                                      callback=self.song_parse)
            except Exception as e:
                print e
                print '爬取list出现错误'

        tag=response.meta["tag"]
        page=int(response.meta["page"]+1)
        if page<self.allPages:
            url = self.baseUrl % (tag, page * self.size)
            yield scrapy.Request(url, callback=self.list_parse, dont_filter=True, meta={'tag': tag, 'page': page})

    def song_parse(self,response):
        #判断判断是否返回json文件来判断能不能下载歌曲
        item=response.meta["item"]
        text = response.text
        context_json = json.loads(text, encoding="utf-8")
        if ('data' not in context_json) or context_json['data'] == '':
            return

        #获取setting中的音乐下载路径
        settings = get_project_settings()
        fileDir=settings.get('SONG_DIR')
        if not os.path.exists(fileDir):
            os.makedirs(fileDir)

        # Download unfinished mp3 again.
        songDir = ("%s\%s.mp3" %(fileDir, item['song_title']))
        songlink = context_json["data"]["songList"][0]["songLink"]
        songPic = context_json["data"]["songList"][0]["songPicRadio"]
        item["album_id"]=context_json["data"]["songList"][0]["albumId"]
        item["singer_id"]=context_json["data"]["songList"][0]["artistId"]
        item["song_dir"] = songDir
        item["song_pic"] = songPic
        try:
            f = urllib2.urlopen(songlink)
            if not os.path.isfile(songDir):
                with open(songDir, "wb") as code:
                    code.write(f.read())
                yield item
            else:
                print "%s      is already downloaded." % item['song_title']
                return
        except Exception as e:
            print e
            print item['song_id'].encode('utf-8')+u'下载失败'
            return














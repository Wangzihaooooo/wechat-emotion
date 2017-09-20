# -*- coding: utf-8 -*-

# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: http://doc.scrapy.org/en/latest/topics/item-pipeline.html
import MySQLdb
from music.items import MusicItem

class save_to_mysql(object):
    @classmethod
    def from_crawler(cls, music):
        return cls(
            mysql_host=music.settings.get('MYSQL_HOST'),
            mysql_username=music.settings.get('MYSQL_USERNAME'),
            mysql_password=music.settings.get('MYSQL_PASSWORD'),
            mysql_db=music.settings.get('MYSQL_DB'),
            mysql_port=music.settings.get('MYSQL_PORT'))

    def __init__(self,mysql_host,mysql_username,mysql_password,mysql_db,mysql_port):
        self.host = mysql_host
        self.port = mysql_port
        self.username = mysql_username
        self.password = mysql_password
        self.db_name = mysql_db


    def open_spider(self,spider):
        self.db = MySQLdb.connect(host=self.host,port=self.port,user=self.username,passwd=self.password,db=self.db_name,charset='utf8')
        self.cursor = self.db.cursor()

    def close_spider(self,spider):
        self.db.close()

    def process_item(self,item,spider):
        try:
            if type(item) == MusicItem:
                try:
                    if (item['song_id'] != None and item['song_title'] != None and item['song_dir'] != None and item['song_tag'] != None):
                        sql = 'insert into ' + 'spider_music' + '(SONG_ID_,SINGER_ID_,ALBUM_ID_) select %s,%s,%s from dual where not exists' \
                                                                 '(select * from spider_music where SONG_ID_=%s)'
                        self.cursor.execute(sql, (int(item['song_id']), int(item['singer_id']), int(item['album_id']),int(item['song_id'])))

                        sql = 'insert into ' + 'spider_song' + '(SONG_ID_,SONG_TITLE_,SONG_PIC_,SONG_DIR_) select %s,%s,%s,%s from dual where not exists' \
                                                               '(select * from spider_song where SONG_ID_=%s)'
                        self.cursor.execute(sql, (int(item['song_id']), item['song_title'], item['song_pic'], item['song_dir'],int(item['song_id'])))

                        sql = 'insert into ' + 'recg_tag_relation' + '(TAG_ID_,SONG_ID_) values(%s,%s);'
                        self.cursor.execute(sql, (int(item['song_tag']), int(item['song_id'])))

                except Exception as e:
                    print e
                    print u'---------------song的数据错误,' + item['song_id'] + u'插入失败----------------------'
                    return


                try:
                    if (item['singer_name'] != None and item['singer_id'] != None):
                        sql = 'insert into ' + 'spider_singer' + '(SINGER_ID_,SINGER_NAME_) select %s,%s from dual where not exists' \
                                                                 '(select * from spider_singer where SINGER_ID_=%s)'
                        self.cursor.execute(sql, (int(item['singer_id']), item['singer_name'], int(item['singer_id'])))
                except Exception as e:
                    print e
                    print u'---------------spider_singer数据库插入错误,' + item['song_id'] + u'插入失败----------------------'
                    return

                try:
                    if (item['album_title'] != None and item['album_id'] != None):
                        sql = 'insert into ' + 'spider_album' + '(ALBUM_ID_,ALBUM_TITLE_) select %s,%s from dual where not exists' \
                                                                 '(select * from spider_album where ALBUM_ID_=%s)'
                        self.cursor.execute(sql, (int(item['album_id']), item['album_title'],int(item['album_id'])))
                except Exception as e:
                    print e
                    print u'---------------spider_album数据库插入错误,' + item['song_id'] + u'插入失败----------------------'
                    return

                self.db.commit()
        except Exception as e:
            print e
            print u'---------------数据库插入错误,'+item['song_id']+u'插入失败----------------------'
            return
        pass
        return item
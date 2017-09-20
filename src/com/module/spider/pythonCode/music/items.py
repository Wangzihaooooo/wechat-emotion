# -*- coding: utf-8 -*-

# Define here the models for your scraped items
#
# See documentation in:
# http://doc.scrapy.org/en/latest/topics/items.html

import scrapy


class MusicItem(scrapy.Item):
    # define the fields for your item here like:
    song_tag= scrapy.Field()

    song_id = scrapy.Field()

    song_title=scrapy.Field()

    singer_name=scrapy.Field()

    album_id=scrapy.Field()

    album_title=scrapy.Field()

    singer_id=scrapy.Field()

    song_dir=scrapy.Field()

    song_pic=scrapy.Field()
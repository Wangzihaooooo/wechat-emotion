# -*- coding: utf-8 -*-：
__author__ = 'yzw'



class Frame(object):

    def __init__(self, bytes, timestamp, duration):
        self.bytes = bytes
        self.timestamp = timestamp
        self.duration = duration
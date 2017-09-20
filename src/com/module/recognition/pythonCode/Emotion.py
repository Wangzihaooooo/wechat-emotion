# -*- coding: utf-8 -*-：
__author__ = 'yzw'
import os
from Feature import Feature
from pybrain.tools.customxml import NetworkReader
import sys
#   获取emotion
def getEmotion(filename):
    os.path.abspath(__file__) #文件绝对路径
    dir = os.path.dirname(os.path.abspath(__file__)) #文件目录绝对路径
    # dir.split(os.sep)[-1] #获取目录名字  os.sep 路径分隔符
    #   读取特征参数
    feature = Feature(filename=filename)
    feature_avg = list(feature.getFeature())

    #   加载神经网络
    net = NetworkReader.readFrom(dir+'\net.xml')

    o = net.activate(feature_avg).tolist()

    result = o.index(max(o))

    return result

if __name__ == "__main__":
    filename = sys.argv[1]
    e = getEmotion(filename)
    print e


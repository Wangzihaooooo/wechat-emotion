# -*- coding: utf-8 -*-：
__author__ = 'yzw'

from Feature import Feature
from pybrain.tools.customxml import NetworkReader
import sys
#   获取emotion
def getEmotion(filename):

    #   读取特征参数
    feature = Feature(filename=filename)
    feature_avg = list(feature.getFeature())

    #   加载神经网络
    net = NetworkReader.readFrom('C:\Users\wangzi\Desktop\VoiceTest\src\main\resources\pythonCode\net.xml')

    o = net.activate(feature_avg).tolist()

    result = o.index(max(o))

    return result

if __name__ == "__main__":

    filename = sys.argv[1]
    e = getEmotion(filename)

    print e

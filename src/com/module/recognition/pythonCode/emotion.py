# -*- coding: utf-8 -*-：


import os
import sys

import numpy as np
from pybrain.tools.customxml.networkreader import NetworkReader
from sklearn.externals import joblib

from feature import get_feature


#   获取emotion
def get_emotion_net(filename):

    filePath =os.path.abspath(__file__) #文件绝对路径
    dirPath = os.path.dirname(filePath) #文件的目录绝对路径

    #   读取特征参数
    feature = np.array(get_feature(filename=filename))
    #   加载神经网络
    net = NetworkReader.readFrom(dirPath + '/net2.xml')
    #   加载降维模型
    pca = joblib.load(dirPath + "/pca.m")
    #   降维
    feature_new = pca.transform(feature.reshape([1,-1]))[0]

    o = net.activate(feature_new).tolist()

    result = o.index(max(o))

    return result

#   获取emotion
def get_emotion_svm(filename):

    filePath =os.path.abspath(__file__) #文件绝对路径
    dirPath = os.path.dirname(filePath) #文件的目录绝对路径

    #   读取特征参数
    feature = np.array(get_feature(filename=filename))
    #   加载神经网络
    svm = joblib.load(dirPath + "/svm2.m")
    #   加载降维模型
    pca = joblib.load(dirPath + "/pca.m")
    #   降维
    feature_new = pca.transform(feature.reshape([1,-1]))

    r = svm.predict(feature_new)[0]

    result = r

    return int(result)


if __name__ == "__main__":

    filename = sys.argv[1]
    e = get_emotion_svm(filename)

    print e

# -*- coding: utf-8 -*-：

import os

import librosa

from st_feature import stFeatureExtraction
from vad import Vad


def get_feature(filename):

    # 端点检测
    vad = Vad(filename)
    newVoice = vad.getNewVoice()

    x, Fs = librosa.load(newVoice)
    st = stFeatureExtraction(x, Fs, 256, 128)

    try:
        os.remove(newVoice)
    except IOError:
        pass

    return st

if __name__=="__main__":
    fileName = "D:\\study\\python\\myVoice3\\voice\\liuchanhg\\angry\\201.wav"
    r = get_feature(fileName)
    print r.shape

# -*- coding: utf-8 -*-

# 提取特征
import librosa
from Vad import Vad
import numpy as np

class Feature(object):

    def __init__(self, filename):
        self.filename = filename
        
    def getFeature(self):
        #端点检测
        vad = Vad(self.filename)
        newVoice = vad.getNewVoice()
        
        y, sr = librosa.load(newVoice)
        #获取mfcc
        ccc = librosa.feature.mfcc(y=y, sr=sr)
        #获取ccc最大特征值对应特征向量
        A = np.mat(ccc)
        B = A * A.T;
        a,b=np.linalg.eig(B)
        m = np.argmax(a);
        
        ccc1 = np.array(b[m].tolist()[0])
        
        #能量构造
        #S, phase = librosa.magphase(librosa.stft(y))
        S = librosa.magphase(librosa.stft(y, window=np.ones, center=False))[0]
        rms = librosa.feature.rmse(S=S)
        rms_max = np.max(rms[0])
        rms_min = np.min(rms[0])
        rms_mean = np.mean(rms[0])
        rms_std = np.std(rms[0])
        
        #过零率
        rate = librosa.feature.zero_crossing_rate(y)
        rete_max = np.max(rate)
        rate_mean = np.mean(rate)
        rate_std = np.std(rate)
        
# =============================================================================
#         S = np.abs(librosa.stft(y))
#         chroma = librosa.feature.chroma_stft(S=S, sr=sr)
#         A = np.mat(chroma)
#         B = A * A.T
#         a,b=np.linalg.eig(B)
#         m = np.argmax(a);
#         chroma1 = np.array(b[m].tolist()[0])
# =============================================================================
        
        # pitch = Pitch(newVoice, sr)
        # pitches = np.array(pitch.getPitch())
        # pitch_max = np.max(pitches)
        # pitch_mean = np.mean(pitches)
        # pitch_std = np.std(pitches)
        # result3 = np.array([pitch_max, pitch_mean, pitch_std])


        # melEnergy = MelEnergy(newVoice)
        # melEnergys = melEnergy.getMelEnergy()

        e = librosa.estimate_tuning(y=y, sr=sr)

        # mel = librosa.feature.melspectrogram(y=y, sr=sr)
        # A = np.mat(mel)
        # B = A * A.T;
        # a, b = np.linalg.eig(B)
        # m = np.argmax(a);
        # mel1 = np.array(b[m].tolist()[0])

        # odf = librosa.onset.onset_strength(y=y, sr=sr, hop_length=512)
        # ac = librosa.autocorrelate(odf, max_size=4 * sr / 512)
        # ac_min = np.min(ac)
        # ac_max = np.max(ac)
        # ac_mean = np.mean(ac)
        # ac_std = np.std(ac)

        result1 = np.array([e, rms_max,rms_min,rms_mean,rms_std,rete_max,rate_mean,rate_std])
        result2 = ccc1
        #result3 = melEnergys
        result = np.append(result1,result2)
        # result = np.append(result,mel1)
        return result
        
        
        
        
        

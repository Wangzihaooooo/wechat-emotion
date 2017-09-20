# -*- coding: utf-8 -*-：
import collections
import contextlib
import wave
import webrtcvad
from Frame import Frame
import time
import os

class Vad(object):

   def __init__(self, fileName):
      self.fileName = fileName

   def getNewVoice(self):
      os.path.abspath(__file__) #文件绝对路径

      dir = os.path.dirname(os.path.abspath(__file__)) #文件目录绝对路径
      audio, sample_rate = self.read_wave(self.fileName)
      vad = webrtcvad.Vad(1)
      frames = self.frame_generator(30, audio, sample_rate)
      frames = list(frames)
      segments = self.vad_collector(sample_rate, 30, 300, vad, frames)
      path = dir+"\tempVoice//" + str(time.time()) + ".wav"
      self.write_wave(path, [j for [i,j] in enumerate(segments)][0], sample_rate)
      return path

   def read_wave(self,path):
      with contextlib.closing(wave.open(path, 'rb')) as wf:
         num_channels = wf.getnchannels()
         assert num_channels == 1
         sample_width = wf.getsampwidth()
         assert sample_width == 2
         sample_rate = wf.getframerate()
         assert sample_rate in (8000, 16000, 32000)
         pcm_data = wf.readframes(wf.getnframes())
         return pcm_data, sample_rate

   def write_wave(self, path, audio, sample_rate):
      with contextlib.closing(wave.open(path, 'wb')) as wf:
         wf.setnchannels(1)
         wf.setsampwidth(2)
         wf.setframerate(sample_rate)
         wf.writeframes(audio)



   def frame_generator(self, frame_duration_ms, audio, sample_rate):
      n = int(sample_rate * (frame_duration_ms / 1000.0) * 2)
      offset = 0
      timestamp = 0.0
      duration = (float(n) / sample_rate) / 2.0
      while offset + n < len(audio):
         yield Frame(audio[offset:offset + n], timestamp, duration)
         timestamp += duration
         offset += n

   def vad_collector(self, sample_rate, frame_duration_ms,
                     padding_duration_ms, vad, frames):
      num_padding_frames = int(padding_duration_ms / frame_duration_ms)
      ring_buffer = collections.deque(maxlen=num_padding_frames)
      triggered = False
      voiced_frames = []
      for frame in frames:

         if not triggered:
            ring_buffer.append(frame)
            num_voiced = len([f for f in ring_buffer
                              if vad.is_speech(f.bytes, sample_rate)])
            if num_voiced > 0.9 * ring_buffer.maxlen:

               triggered = True
               voiced_frames.extend(ring_buffer)
               ring_buffer.clear()
         else:
            voiced_frames.append(frame)
            ring_buffer.append(frame)
            num_unvoiced = len([f for f in ring_buffer
                                if not vad.is_speech(f.bytes, sample_rate)])
            if num_unvoiced > 0.9 * ring_buffer.maxlen:

               triggered = False
               yield b''.join([f.bytes for f in voiced_frames])
               ring_buffer.clear()
               voiced_frames = []

      if voiced_frames:
         yield b''.join([f.bytes for f in voiced_frames])


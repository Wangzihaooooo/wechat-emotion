package com.sys.service.Impl;

import com.sys.persistence.dao.SpeechDao;
import com.sys.persistence.domain.Speech;
import com.sys.service.SpeechService;

import javax.annotation.Resource;

/**
 * description:
 * Created on 2017/9/18 21:11
 */
public class SpeechServiceImpl implements SpeechService{
    @Resource
    private SpeechDao speechDao;
    @Override
    public void addSpeech(Speech speech) {
        speech.setWavPath(speech.getSilkPath().replace(".silk",".webn"));
        speech.setWavPath(speech.getSilkPath().replace(".webn",".wav"));
        speechDao.insertSelective(speech);
    }

    @Override
    public Speech getSpeechBySpeechId(Integer speechId) {
        return speechDao.selectByPrimaryKey(speechId);
    }

    @Override
    public Speech getSpeechByUserId(Integer userId) {
        return speechDao.selectByPrimaryKey(userId);
    }

}

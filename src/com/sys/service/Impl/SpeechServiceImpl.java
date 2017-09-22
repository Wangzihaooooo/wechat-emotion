package com.sys.service.Impl;

import com.sys.persistence.dao.SpeechDao;
import com.sys.persistence.domain.Speech;
import com.sys.service.SpeechService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * description:
 * Created on 2017/9/18 21:11
 */
@Service
public class SpeechServiceImpl implements SpeechService{
    @Resource
    private SpeechDao speechDao;
    @Override
    public int addSpeech(Speech speech) {
        return speechDao.insertSelective(speech);
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

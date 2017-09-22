package com.sys.service.Impl;

import com.sys.persistence.dao.SpeechRecordDao;
import com.sys.persistence.domain.SpeechRecord;
import com.sys.service.SpeechRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * description:
 * Created on 2017/9/22 12:57
 **/
@Service
public class SpeechRecordServiceImpl implements SpeechRecordService{
    @Resource
    private SpeechRecordDao speechRecordDao;
    @Override
    public int addSpeechRecord(SpeechRecord speechRecord) {
        return speechRecordDao.insertSelective(speechRecord);
    }

    @Override
    public SpeechRecord getSpeechRecordByRecordId(int recordId) {
        return speechRecordDao.selectByPrimaryKey(recordId);
    }
}

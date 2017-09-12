package com.sys.persistence.dao;

import com.sys.persistence.domain.SpeechRecord;

public interface SpeechRecordDao {
    int deleteByPrimaryKey(String recordId);

    int insert(SpeechRecord record);

    int insertSelective(SpeechRecord record);

    SpeechRecord selectByPrimaryKey(String recordId);

    int updateByPrimaryKeySelective(SpeechRecord record);

    int updateByPrimaryKey(SpeechRecord record);
}
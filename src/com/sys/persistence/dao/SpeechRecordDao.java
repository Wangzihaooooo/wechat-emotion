package com.sys.persistence.dao;

import com.sys.persistence.domain.SpeechRecord;

public interface SpeechRecordDao {
    int deleteByPrimaryKey(Integer recordId);

    int insert(SpeechRecord record);

    int insertSelective(SpeechRecord record);

    SpeechRecord selectByPrimaryKey(Integer recordId);

    int updateByPrimaryKeySelective(SpeechRecord record);

    int updateByPrimaryKey(SpeechRecord record);
}
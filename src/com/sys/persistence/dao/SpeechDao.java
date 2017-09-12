package com.sys.persistence.dao;

import com.sys.persistence.domain.Speech;

public interface SpeechDao {
    int deleteByPrimaryKey(String speechId);

    int insert(Speech record);

    int insertSelective(Speech record);

    Speech selectByPrimaryKey(String speechId);

    int updateByPrimaryKeySelective(Speech record);

    int updateByPrimaryKey(Speech record);
}
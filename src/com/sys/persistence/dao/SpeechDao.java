package com.sys.persistence.dao;

import com.sys.persistence.domain.Speech;

public interface SpeechDao {
    int deleteByPrimaryKey(Integer speechId);

    int insert(Speech record);

    int insertSelective(Speech record);

    Speech selectByPrimaryKey(Integer speechId);

    Speech selectByUserId(Integer speechId);

    int updateByPrimaryKeySelective(Speech record);

    int updateByPrimaryKey(Speech record);

}
package com.sys.persistence.dao;

import com.sys.persistence.domain.TextRecord;

public interface TextRecordDao {
    int deleteByPrimaryKey(String recordId);

    int insert(TextRecord record);

    int insertSelective(TextRecord record);

    TextRecord selectByPrimaryKey(String recordId);

    int updateByPrimaryKeySelective(TextRecord record);

    int updateByPrimaryKey(TextRecord record);
}
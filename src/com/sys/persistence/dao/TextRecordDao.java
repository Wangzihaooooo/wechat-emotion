package com.sys.persistence.dao;

import com.sys.persistence.domain.TextRecord;

public interface TextRecordDao {
    int deleteByPrimaryKey(Integer recordId);

    int insert(TextRecord record);

    int insertSelective(TextRecord record);

    TextRecord selectByPrimaryKey(Integer recordId);

    int updateByPrimaryKeySelective(TextRecord record);

    int updateByPrimaryKey(TextRecord record);
}
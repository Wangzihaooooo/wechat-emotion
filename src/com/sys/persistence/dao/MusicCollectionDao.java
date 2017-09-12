package com.sys.persistence.dao;

import com.sys.persistence.domain.MusicCollection;

public interface MusicCollectionDao {
    int deleteByPrimaryKey(String recordId);

    int insert(MusicCollection record);

    int insertSelective(MusicCollection record);

    MusicCollection selectByPrimaryKey(String recordId);

    int updateByPrimaryKeySelective(MusicCollection record);

    int updateByPrimaryKey(MusicCollection record);
}
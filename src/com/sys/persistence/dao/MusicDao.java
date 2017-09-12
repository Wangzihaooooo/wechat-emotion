package com.sys.persistence.dao;

import com.sys.persistence.domain.Music;

public interface MusicDao {
    int deleteByPrimaryKey(String songId);

    int insert(Music record);

    int insertSelective(Music record);

    Music selectByPrimaryKey(String songId);

    Music selectByTag(String songTag);

    int updateByPrimaryKeySelective(Music record);

    int updateByPrimaryKey(Music record);
}
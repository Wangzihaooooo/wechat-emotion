package com.module.spider.persistence.dao;

import com.module.spider.persistence.domain.Song;

public interface SongDao {
    int deleteByPrimaryKey(Integer songId);

    int insert(Song record);

    int insertSelective(Song record);

    Song selectByPrimaryKey(Integer songId);

    int updateByPrimaryKeySelective(Song record);

    int updateByPrimaryKey(Song record);
}
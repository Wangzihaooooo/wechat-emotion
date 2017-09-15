package com.module.spider.persistence.dao;

import com.module.spider.persistence.domain.Album;

public interface AlbumDao {
    int deleteByPrimaryKey(Integer albumId);

    int insert(Album record);

    int insertSelective(Album record);

    Album selectByPrimaryKey(Integer albumId);

    int updateByPrimaryKeySelective(Album record);

    int updateByPrimaryKey(Album record);
}
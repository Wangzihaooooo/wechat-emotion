package com.module.spider.persistence.dao;

import com.module.spider.persistence.domain.Music;

public interface MusicDao {
    int deleteByPrimaryKey(Integer musicId);

    int insert(Music record);

    int insertSelective(Music record);

    Music selectByPrimaryKey(Integer musicId);

    int updateByPrimaryKeySelective(Music record);

    int updateByPrimaryKey(Music record);
}
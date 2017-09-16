package com.module.spider.persistence.dao;

import com.module.spider.persistence.domain.Music;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MusicDao {
    int deleteByPrimaryKey(Integer musicId);

    int insert(Music record);

    int insertSelective(Music record);

    Music selectByPrimaryKey(Integer musicId);

    int updateByPrimaryKeySelective(Music record);

    int updateByPrimaryKey(Music record);

    Music selectBySongId(Integer songId);

    List<Music> selectBySongIdList(@Param("songIdList") List<Integer> songIdList);
}
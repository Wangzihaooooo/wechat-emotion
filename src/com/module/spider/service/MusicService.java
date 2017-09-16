package com.module.spider.service;

import com.module.spider.persistence.domain.Music;

import java.util.List;

/**
 * description:
 * Created on 2017/9/16 10:51
 */
public interface MusicService {

    /**
     * Gets musice by id.
     *
     * @param songId the song id
     * @return the musice by id
     */
    Music getMusiceById(int songId);

    /**
     * Gets music list by song id.
     *
     * @param songIdList the song id list
     * @return the music list by song id
     */
    List<Music> getMusicListBySongId(List<Integer> songIdList);
}

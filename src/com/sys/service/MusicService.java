package com.sys.service;

import com.module.spider.persistence.domain.Music;

/**
 * description:
 * Created on 2017/9/9 22:00
 */
public interface MusicService {

    /**
     * Gets musice by id.
     *
     * @param songId the song id
     * @return the musice by id
     */
    Music getMusiceById(int songId);


}

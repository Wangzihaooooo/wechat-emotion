package com.sys.service;

import com.sys.persistence.domain.Music;

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
    Music getMusiceById(String songId);

    /**
     * Gets musice by tag.
     *
     * @param songTag the song tag
     * @return the musice by tag
     */
    Music getMusiceByTag(String songTag);
}

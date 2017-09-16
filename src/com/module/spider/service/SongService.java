package com.module.spider.service;

import com.module.spider.persistence.domain.Song;

/**
 * description:
 * Created on 2017/9/16 11:02
 */
public interface SongService {

    /**
     * Gets song by id.
     *
     * @param id the id
     * @return the song by id
     */
    Song getSongById(int id);
}

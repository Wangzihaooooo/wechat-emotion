package com.module.spider.service;

import com.module.spider.persistence.domain.Album;

/**
 * description:
 * Created on 2017/9/16 11:01
 */
public interface AlbumService {

    /**
     * Gets album by id.
     *
     * @param id the id
     * @return the album by id
     */
    Album getAlbumById(int id);
}

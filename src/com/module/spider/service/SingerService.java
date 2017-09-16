package com.module.spider.service;

import com.module.spider.persistence.domain.Singer;

/**
 * description:
 * Created on 2017/9/16 11:01
 */
public interface SingerService {

    /**
     * Gets singer by id.
     *
     * @param id the id
     * @return the singer by id
     */
    Singer getSingerById(int id);
}

package com.module.spider.service.Impl;

import com.module.spider.persistence.dao.AlbumDao;
import com.module.spider.persistence.domain.Album;
import com.module.spider.service.AlbumService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * description:
 * Created on 2017/9/16 11:01
 **/
@Service
public class AlbumServiceImpl implements AlbumService{
    @Resource
    private AlbumDao albumDao;

    @Override
    public Album getAlbumById(int id) {
        return albumDao.selectByPrimaryKey(id);
    }
}

package com.module.spider.service.Impl;

import com.module.spider.persistence.dao.SongDao;
import com.module.spider.persistence.domain.Song;
import com.module.spider.service.SongService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * description:
 * Created on 2017/9/16 11:01
 **/
@Service
public class SongServiceImpl implements SongService{
    @Resource
    private SongDao songDao;

    @Override
    public Song getSongById(int id) {
        return songDao.selectByPrimaryKey(id);
    }
}

package com.sys.service.Impl;

import com.sys.persistence.dao.MusicDao;
import com.sys.persistence.domain.Music;
import com.sys.service.MusicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * description:
 * Created on 2017/9/9 22:00
 **/
@Service("musicService")
public class MusicServiceImpl implements MusicService{
    @Resource
    MusicDao musicDao;

    @Override
    public Music getMusiceById(String songId) {
        return musicDao.selectByPrimaryKey(songId);
    }

    @Override
    public Music getMusiceByTag(String songTag) {
        return musicDao.selectByTag(songTag);
    }
}

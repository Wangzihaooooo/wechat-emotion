package com.module.spider.service.Impl;

import com.module.spider.persistence.dao.MusicDao;
import com.module.spider.persistence.domain.Music;
import com.module.spider.service.MusicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 * Created on 2017/9/16 10:52
 **/
@Service
public class MusicServiceImpl implements MusicService {
    @Resource
    private MusicDao musicDao;
    @Override
    public Music getMusiceById(int songId) {
        return musicDao.selectByPrimaryKey(songId);
    }

    @Override
    public List<Music> getMusicListBySongId(List<Integer> songIdList) {
        return musicDao.selectBySongIdList(songIdList);
    }
}

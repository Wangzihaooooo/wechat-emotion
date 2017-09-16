package com.module.spider.service.Impl;

import com.module.spider.persistence.dao.SingerDao;
import com.module.spider.persistence.domain.Singer;
import com.module.spider.service.SingerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * description:
 * Created on 2017/9/16 11:00
 **/
@Service
public class SingerServiceImpl implements SingerService{
    @Resource
    private SingerDao singerDao;
    @Override
    public Singer getSingerById(int id) {
        return singerDao.selectByPrimaryKey(id);
    }
}

package com.module.recognition.service.Impl;

import com.module.recognition.persistence.dao.TagRelationDao;
import com.module.recognition.service.TagRelationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 * Created on 2017/9/16 23:46
 **/
@Service
public class TagRelationServiceImpl implements TagRelationService{
    @Resource
    private TagRelationDao tagRelationDao;
    @Override
    public List<Integer> selectMusicListByTag(int tagId, int count) {
        return tagRelationDao.selectMusicListByTag(tagId,count);
    }
}

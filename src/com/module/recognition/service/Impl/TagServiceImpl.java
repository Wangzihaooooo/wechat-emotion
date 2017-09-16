package com.module.recognition.service.Impl;

import com.module.recognition.persistence.dao.TagDao;
import com.module.recognition.persistence.domain.Tag;
import com.module.recognition.service.TagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * description:
 * Created on 2017/9/15 14:35
 **/
@Service
public class TagServiceImpl implements TagService{
    @Resource
    private TagDao tagDao;


}

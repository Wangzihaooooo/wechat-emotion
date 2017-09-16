package com.module.recognition.core;

import com.module.recognition.persistence.dao.TagRelationDao;
import com.module.recognition.service.TagRelationService;
import com.module.recognition.service.TagService;
import com.module.recognition.util.RandomRecommendUtil;
import com.module.spider.persistence.dao.MusicDao;
import com.module.spider.persistence.domain.Music;
import com.module.spider.service.MusicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * description:
 * Created on 2017/9/16 11:07
 **/

public class RecommendMusic {
    @Resource
    private TagRelationService tagRelationService;
    @Resource
    private MusicService       musicService;

    public List<Music> getMusicGroup(int tagKey, int count){
        //从数据库中随机获取tagkey标签共count首歌曲的songId
        List<Integer> integerList=tagRelationService.selectMusicListByTag(tagKey,count);
        //根据songId获取
        List<Music> musicList=musicService.getMusicListBySongId(integerList);
        return musicList;
    }
}

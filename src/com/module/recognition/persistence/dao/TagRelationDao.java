package com.module.recognition.persistence.dao;

import com.module.spider.persistence.domain.Music;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * description:
 * Created on 2017/9/16 20:29
 */
public interface TagRelationDao {
    /**
     * Select music list by tag list.
     *
     * @param tagId the tag id 情绪标签的id
     * @param count the count 需要随机获取的总数量
     * @return the list
     */
    List<Integer> selectMusicListByTag(@Param("tagId") int tagId, @Param("count") int count);
}

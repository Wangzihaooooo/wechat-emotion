package com.module.recognition.service;

import java.util.List;

/**
 * description:
 * Created on 2017/9/16 23:45
 */
public interface TagRelationService {

    /**
     * Select music list by tag list.
     *
     * @param tagId the tag id
     * @param count the count
     * @return the list
     */
    List<Integer> selectMusicListByTag(int tagId, int count);
}

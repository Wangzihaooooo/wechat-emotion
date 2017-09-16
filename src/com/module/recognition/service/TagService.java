package com.module.recognition.service;

import com.module.recognition.persistence.domain.Tag;

/**
 * description:
 * Created on 2017/9/15 14:34
 */
public interface TagService {

    /**
     * Gets song sum by tag.
     *
     * @return the song sum by tag
     */
    int getSongSumByTag(int tagKey);
}

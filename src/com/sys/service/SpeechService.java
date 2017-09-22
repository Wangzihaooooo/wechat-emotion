package com.sys.service;

import com.sys.persistence.domain.Speech;

/**
 * description:
 * Created on 2017/9/18 21:11
 */
public interface SpeechService {

    /**
     * Add speech.
     *
     * @param speech the speech
     */
    public int addSpeech(Speech speech);

    /**
     * 根据 语音id 获取语音
     *
     * @param speechId the speech id
     * @return the speech by speech id
     */
    public Speech getSpeechBySpeechId(Integer speechId);

    /**
     * 根据 用户id 获取语音
     *
     * @param userId the user id
     * @return the speech by user id
     */
    public Speech getSpeechByUserId(Integer userId);

}

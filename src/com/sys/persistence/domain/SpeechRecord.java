package com.sys.persistence.domain;

import java.util.Date;

public class SpeechRecord {
    private Integer recordId;

    private Integer musicId;

    private Integer userId;

    private Integer speechId;

    private Date date;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getMusicId() {
        return musicId;
    }

    public void setMusicId(Integer musicId) {
        this.musicId = musicId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSpeechId() {
        return speechId;
    }

    public void setSpeechId(Integer speechId) {
        this.speechId = speechId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
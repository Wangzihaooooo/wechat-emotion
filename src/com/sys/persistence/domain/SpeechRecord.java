package com.sys.persistence.domain;

import java.util.Date;

public class SpeechRecord {
    private String recordId;

    private String songId;

    private String userId;

    private String speechId;

    private String regnitionEmotionId;

    private Date date;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId == null ? null : recordId.trim();
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId == null ? null : songId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getSpeechId() {
        return speechId;
    }

    public void setSpeechId(String speechId) {
        this.speechId = speechId == null ? null : speechId.trim();
    }

    public String getRegnitionEmotionId() {
        return regnitionEmotionId;
    }

    public void setRegnitionEmotionId(String regnitionEmotionId) {
        this.regnitionEmotionId = regnitionEmotionId == null ? null : regnitionEmotionId.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
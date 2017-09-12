package com.sys.persistence.domain;

import java.util.Date;

public class TextRecord {
    private String recordId;

    private String userId;

    private String songId;

    private String emotionId;

    private Date date;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId == null ? null : recordId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId == null ? null : songId.trim();
    }

    public String getEmotionId() {
        return emotionId;
    }

    public void setEmotionId(String emotionId) {
        this.emotionId = emotionId == null ? null : emotionId.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
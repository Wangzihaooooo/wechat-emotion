package com.sys.persistence.domain;

import java.util.Date;

public class Speech {
    private String speechId;

    private String userId;

    private Date date;

    private String speechDir;

    public String getSpeechId() {
        return speechId;
    }

    public void setSpeechId(String speechId) {
        this.speechId = speechId == null ? null : speechId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSpeechDir() {
        return speechDir;
    }

    public void setSpeechDir(String speechDir) {
        this.speechDir = speechDir == null ? null : speechDir.trim();
    }
}
package com.sys.persistence.domain;

import java.util.Date;

public class Speech {
    private Integer speechId;

    private Integer userId;

    private Date date;

    private String speechDir;

    public Integer getSpeechId() {
        return speechId;
    }

    public void setSpeechId(Integer speechId) {
        this.speechId = speechId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
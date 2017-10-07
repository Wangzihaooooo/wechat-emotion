package com.sys.persistence.domain;

import java.util.Date;

public class Speech {
    private Integer speechId;

    private Integer userId;

    private Integer tagId;

    private Date date;

    private String silkPath;

    private String webnPath;

    private String wavPath;

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

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

    public String getSilkPath() {
        return silkPath;
    }

    public void setSilkPath(String silkPath) {
        this.silkPath = silkPath == null ? null : silkPath.trim();
    }

    public String getWebnPath() {
        return webnPath;
    }

    public void setWebnPath(String webnPath) {
        this.webnPath = webnPath == null ? null : webnPath.trim();
    }

    public String getWavPath() {
        return wavPath;
    }

    public void setWavPath(String wavPath) {
        this.wavPath = wavPath == null ? null : wavPath.trim();
    }
}
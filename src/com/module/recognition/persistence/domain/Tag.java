package com.module.recognition.persistence.domain;

public class Tag {
    private Integer tagId;

    private String tagContext;

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagContext() {
        return tagContext;
    }

    public void setTagContext(String tagContext) {
        this.tagContext = tagContext == null ? null : tagContext.trim();
    }

}
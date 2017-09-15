package com.module.spider.persistence.domain;

public class Album {
    private Integer albumId;

    private String albumTitle;

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle == null ? null : albumTitle.trim();
    }
}
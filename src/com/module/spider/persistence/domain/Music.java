package com.module.spider.persistence.domain;

public class Music {
    private Integer musicId;

    private Integer songId;

    private Integer singerId;

    private Integer albumId;

    public Integer getMusicId() {
        return musicId;
    }

    public void setMusicId(Integer musicId) {
        this.musicId = musicId;
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public Integer getSingerId() {
        return singerId;
    }

    public void setSingerId(Integer singerId) {
        this.singerId = singerId;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    @Override
    public String toString() {
        return "Music{" +
                "musicId=" + musicId +
                ", songId=" + songId +
                ", singerId=" + singerId +
                ", albumId=" + albumId +
                '}';
    }
}
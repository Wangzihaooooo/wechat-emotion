package com.module.spider.persistence.domain;

public class Song {
    private Integer songId;

    private String songRefId;

    private String songTitle;

    private String songTime;

    private String songPic;

    private String songDir;

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public String getSongRefId() {
        return songRefId;
    }

    public void setSongRefId(String songRefId) {
        this.songRefId = songRefId == null ? null : songRefId.trim();
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle == null ? null : songTitle.trim();
    }

    public String getSongTime() {
        return songTime;
    }

    public void setSongTime(String songTime) {
        this.songTime = songTime == null ? null : songTime.trim();
    }

    public String getSongPic() {
        return songPic;
    }

    public void setSongPic(String songPic) {
        this.songPic = songPic == null ? null : songPic.trim();
    }

    public String getSongDir() {
        return songDir;
    }

    public void setSongDir(String songDir) {
        this.songDir = songDir == null ? null : songDir.trim();
    }
}
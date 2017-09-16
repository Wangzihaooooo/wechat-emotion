package com.module.spider.persistence.domain;

public class Song {
    private Integer songId;

    private String songTitle;

    private String songPic;

    private String songDir;

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle == null ? null : songTitle.trim();
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

    @Override
    public String toString() {
        return "Song{" +
                "songId=" + songId +
                ", songTitle='" + songTitle + '\'' +
                ", songPic='" + songPic + '\'' +
                ", songDir='" + songDir + '\'' +
                '}';
    }
}
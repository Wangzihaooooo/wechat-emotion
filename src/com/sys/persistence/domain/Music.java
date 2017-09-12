package com.sys.persistence.domain;

public class Music {
    private String songId;

    private String songTag;

    private String songTitle;

    private String songTime;

    private String songPic;

    private String songDir;

    private String singerName;

    private String albumTitle;

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId == null ? null : songId.trim();
    }

    public String getSongTag() {
        return songTag;
    }

    public void setSongTag(String songTag) {
        this.songTag = songTag == null ? null : songTag.trim();
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

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName == null ? null : singerName.trim();
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle == null ? null : albumTitle.trim();
    }
}
package com.sys.controller;

import com.module.spider.persistence.domain.Album;
import com.module.spider.persistence.domain.Singer;
import com.module.spider.persistence.domain.Song;
import com.module.spider.service.AlbumService;
import com.module.spider.service.MusicService;
import com.module.spider.service.SingerService;
import com.module.spider.service.SongService;
import com.sys.core.RecommendMusicService;
import com.module.spider.persistence.domain.Music;
import com.sys.persistence.domain.SpeechRecord;
import com.sys.persistence.domain.User;
import com.sys.service.SpeechRecordService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
/**
 * description:推荐音乐的控制器
 * Created on 2017/9/22 10:00
 **/
@Controller
public class RecommendMusicController {
    @Resource
    private RecommendMusicService recommendMusicService;
    @Resource
    private SpeechRecordService   speechRecordService;
    @Resource
    private MusicService          musicService;
    @Resource
    private SongService           songService;
    @Resource
    private AlbumService          albumService;
    @Resource
    private SingerService         singerService;
    @RequestMapping("recommendMusic")
    public @ResponseBody List<Music> recommendMusic(HttpServletRequest request,
                                         @RequestParam("emotionResult") int emotionResult,
                                         @RequestParam("speechId") int speechId,
                                         HttpSession session){
        ModelAndView modelAndView=new ModelAndView();
        List<Music> musicList=recommendMusicService.getMusicGroup(emotionResult,10);
        User user=(User)session.getAttribute("userSession");
        Music music;
        SpeechRecord speechRecord;
        Iterator iterator=musicList.iterator();
        while(iterator.hasNext()){
            speechRecord=new SpeechRecord();
            music=(Music)iterator.next();
            speechRecord.setMusicId(music.getMusicId());
            speechRecord.setSpeechId(speechId);
            speechRecord.setUserId(user.getUserId());
            speechRecord.setDate(new Date());
            speechRecordService.addSpeechRecord(speechRecord);
        }
        return musicList;
    }

    @RequestMapping("getMusicDetail")
    public @ResponseBody Map<String,Object> getMusicDetail(@RequestParam("musicId") int musicId){
        Music music=musicService.getMusiceById(musicId);
        Song song=songService.getSongById(music.getSongId());
        Singer singer=singerService.getSingerById(music.getSingerId());
        Album album=albumService.getAlbumById(music.getAlbumId());
        Map<String,Object> deatilMap=new HashMap<>();
        deatilMap.put("song",song);
        deatilMap.put("singer",singer);
        deatilMap.put("album",album);
        return deatilMap;
    }

}

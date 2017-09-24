package com.sys.controller;

import com.module.spider.persistence.domain.Album;
import com.module.spider.persistence.domain.Music;
import com.module.spider.persistence.domain.Singer;
import com.module.spider.persistence.domain.Song;
import com.module.spider.service.AlbumService;
import com.module.spider.service.MusicService;
import com.module.spider.service.SingerService;
import com.module.spider.service.SongService;
import com.sys.core.RecommendMusicService;
import com.sys.persistence.domain.SpeechRecord;
import com.sys.persistence.domain.User;
import com.sys.service.SpeechRecordService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * description:推荐音乐的控制器
 * Created on 2017/9/22 10:00
 */
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

    /**
     * Recommend music list.
     * 推荐音乐列表 但不包含具体音乐信息
     * @param request       the request
     * @param emotionResult the emotion result
     * @param speechId      the speech id
     * @param session       the session
     * @return the list
     */
    @RequestMapping("recommendMusic")
    @ResponseBody //返回的结果直接显示在界面上，数据会经过springmvc的fastJsonHttpMessageConverter，转化成json格式
    public  Map<String,Object> recommendMusic(HttpServletRequest request,
                                         @RequestParam("emotionResult") int emotionResult,
                                         @RequestParam("speechId") int speechId,
                                         HttpSession session){
        List<Music> musicList=recommendMusicService.getMusicGroup(emotionResult,10);//随机从数据库选取指定数量歌曲，，默认是10首
        Map<String,Object> responseMap=new HashMap<>();//返回给客户端map类型，里面包含全部歌曲的music信息和识别的情绪结果id
        responseMap.put("musicList",musicList);
        responseMap.put("emtionResult",emotionResult);
        User user=(User)session.getAttribute("userSession");//从session中提取user信息
        //循环提取歌曲列表中每首歌music信息，保存到数据库的speechrecord表里，进行历史记录
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
        return responseMap;
    }
    /**
     * Gets music detail.
     * 根据musicId来获取音乐具体信息 即song singer album
     * @param musicId the music id
     * @return the music detail
     */
    @RequestMapping("getMusicDetail")
    public @ResponseBody Map<String,Object> getMusicDetail(@RequestParam("musicId") int musicId){
        //根据music的id分别从数据库获取song singer albumd的数据 并保存到Map<String,Object>传给后端
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

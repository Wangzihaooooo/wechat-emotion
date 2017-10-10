package com.sys.controller;

import com.sys.persistence.domain.SpeechRecord;
import com.sys.persistence.domain.User;
import com.sys.service.SpeechRecordService;
import com.sys.service.SpeechService;
import com.sys.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description:情绪统计控制器
 * Created on 2017/10/7 23:15
 **/
@Controller
public class EmotionStatisticsController {
    @Resource
    private SpeechRecordService speechRecordService;
    @Resource
    private SpeechService speechService;
    @Resource
    private UserService userService;
    @RequestMapping("/EmotionStatistics")
    @ResponseBody
    public Map<String,Object> emotionStatistics(@RequestParam("dateBegin") String dateBegin,
                                                @RequestParam("dateEnd") String dateEnd,
                                                HttpSession session){
        Map<String,Object> resultMap=new HashMap<>();//最终返回给前端的Map
        Map<Integer,Integer> tagIdMap=new HashMap<>();//存放每个speechId对应的tagId

        //获取speechRecord
        User user=(User)session.getAttribute("userSession");//获取会话session中保存的用户数据
        List<SpeechRecord> speechRecordList=speechRecordService.getSpeechRecordByUserIdAndDate(user.getUserId(),dateBegin,dateEnd);

        //获取tagId
        for(SpeechRecord speechRecord:speechRecordList){
            int speechId=speechRecord.getSpeechId();
            int tagId = speechService.getSpeechBySpeechId(speechId).getTagId();
            if(!tagIdMap.containsKey(speechId))
                tagIdMap.put(speechId,tagId);
        }
        resultMap.put("speechRecordList",speechRecordList);
        resultMap.put("tagIdMap",tagIdMap);
        return resultMap;
    }

}

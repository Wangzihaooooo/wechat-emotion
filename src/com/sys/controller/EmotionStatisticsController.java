package com.sys.controller;

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
import java.util.List;

/**
 * description:情绪统计控制器
 * Created on 2017/10/7 23:15
 **/
@Controller
public class EmotionStatisticsController {
    @Resource
    private SpeechRecordService speechRecordService;
    @RequestMapping("/EmotionStatistics")
    @ResponseBody
    public List<SpeechRecord> emotionStatistics(HttpServletRequest request,
                                  @RequestParam("dateBegin") String dateBegin,
                                  @RequestParam("dateEnd") String dateEnd,
                                  HttpSession session){
        User user=(User)session.getAttribute("userSession");//获取会话session中保存的用户数据
        List<SpeechRecord> speechRecordList=speechRecordService.getSpeechRecordByUserIdAndDate(user.getUserId(),dateBegin,dateEnd);
        /*Iterator iterator=speechRecordList.iterator();
        while(iterator.hasNext()) {

        }*/
        return speechRecordList;
    }

}

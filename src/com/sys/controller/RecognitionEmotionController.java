package com.sys.controller;

import com.sys.core.RecognitionEmotionService;
import com.sys.core.SpeechDecorderService;
import com.sys.persistence.domain.Speech;
import com.sys.persistence.domain.User;
import com.sys.service.SpeechService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;


/**
 * description:对上传的录音文件进行一系列操作，总共分为三步
 * 1.线对silk文件进行解密成webn，再解码成wav
 * 2.对wav文件进行机器学习识别
 * 3.根据识别的情绪推荐音乐即重定向到RecommendMusicController
 * Created on 2017/9/22 9:19
 */
@Controller
public class RecognitionEmotionController {
    @Resource
    private SpeechDecorderService     speechDecorderService;
    @Resource
    private RecognitionEmotionService recognitionEmotionService;
    @Resource
    private SpeechService speechService;
    private static Logger log = Logger.getLogger(RecognitionEmotionController.class.getName());
    /**
     * Recognition emotion string.
     * 情绪识别的核心调用方法
     * @param request    the request
     * @param attributes the attributes
     * @param session    the session
     * @return the string
     */
    @RequestMapping("/recognitionEmotion")
    public String recognitionEmotion(HttpServletRequest request,RedirectAttributes attributes,HttpSession session){
        Speech speech=new Speech();
        User user=(User)session.getAttribute("userSession");//获取会话session中保存的用户数据
        String silkFileName=request.getParameter("silkFileName");
        String webnFileName=silkFileName.replace(".silk",".webn");
        String wavFileName=silkFileName.replace(".silk",".wav");
        speech.setUserId(user.getUserId());
        speech.setDate(new Date());
        speech.setSilkPath(silkFileName);
        speech.setWebnPath(webnFileName);
        speech.setWavPath(wavFileName);

        //调用speechDecorderService进行解密解码
        String speechPath=System.getProperty("speechPath");
        boolean decordSuccess=speechDecorderService.decode(
                speechPath+"/"+silkFileName,
                speechPath+"/"+webnFileName,
                speechPath+"/"+wavFileName);
        if(decordSuccess){
            int emotionResult= recognitionEmotionService.recognitionEmotion(wavFileName);
            if(emotionResult!=-1){
                log.info("情绪识别结果:"+String.valueOf(emotionResult));
                speech.setTagId(emotionResult);
                //将speech录音文件的相关数据存入数据库，并且跳转到recommendMusic路径的控制器方法
                speechService.addSpeech(speech);
                int speechId=speech.getSpeechId();//因为speechId在数据库中是自增的，因此需要插入后获取通过SELECT LAST_INSERT_ID()获取
                //将数据保存在RedirectAttributes类中，将数据传递给跳转后的页面
                attributes.addAttribute("emotionResult",emotionResult);
                attributes.addAttribute("speechId",speechId);
                return "redirect:/recommendMusic";
            }else {
                log.error("情绪识别失败");
                return "error";
            }
        }else{
            return "error";
        }
    }
}

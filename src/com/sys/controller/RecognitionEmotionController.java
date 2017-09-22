package com.sys.controller;

import com.module.recognition.core.RecognitionEmotionService;
import com.sys.core.SpeechDecorderService;
import com.sys.persistence.domain.Speech;
import com.sys.persistence.domain.User;
import com.sys.service.SpeechService;
import com.sys.util.PropertyUtil;
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
 **/
@Controller
public class RecognitionEmotionController {
    @Resource
    private SpeechDecorderService     speechDecorderService;
    @Resource
    private RecognitionEmotionService recognitionEmotionService;
    @Resource
    private SpeechService speechService;
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
        boolean decordSuccess=speechDecorderService.decode(
                PropertyUtil.getProperty("filePath.properties","speech.path")+"\\"+silkFileName,
                PropertyUtil.getProperty("filePath.properties","speech.path")+"\\"+webnFileName,
                PropertyUtil.getProperty("filePath.properties","speech.path")+"\\"+wavFileName);
        if(decordSuccess){
            speechService.addSpeech(speech);
            int speechId=speech.getSpeechId();//因为speechId在数据库中是自增的，因此需要插入后获取通过SELECT LAST_INSERT_ID()获取
            int emotionResult= recognitionEmotionService.recognitionEmotion(wavFileName);
            attributes.addAttribute("emotionResult",emotionResult);
            attributes.addAttribute("speechId",speechId);
            return "redirect:/recommendMusic";
        }else{
            return "error";
        }
    }
}

package com.sys.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sys.core.RecommendMusicService;
import com.sys.core.SpeechDecorderService;
import com.sys.service.UserService;
import com.sys.util.FileUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.module.recognition.core.RecognitionEmotionService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * description:
 * Created on 2017/9/19 11:15
 **/
@Controller
public class FileController {
    @Resource
    private SpeechDecorderService     speechDecorderService;
    @Resource
    private RecommendMusicService     recommendMusicService;
    @Resource
    private RecognitionEmotionService recognitionEmotionService;
    @Resource
    private UserService userService;
    @RequestMapping(value="/{formName}")
    public String loginForm(@PathVariable String formName){
        // 动态跳转页面
        return formName;
    }
    // 上传文件会自动绑定到MultipartFile中
    @RequestMapping(value="/upload",method= RequestMethod.POST)
    public String upload(HttpServletRequest request,
                         @RequestParam("file") MultipartFile multipartFile,
                         RedirectAttributes attributes,
                         HttpSession session) throws Exception{
        session.setAttribute("userSession",userService.getUserById(1));
        String silkFileName=multipartFile.getOriginalFilename(); // 得到上传时的文件名
        attributes.addAttribute("silkFileName",silkFileName);
        boolean success=FileUtil.upload(multipartFile,"silk");
        if(success){
            return "redirect:/recognitionEmotion";
        }else {
            return "error";
        }
    }

    @RequestMapping(value="/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request,
                                           @RequestParam("filename") String filename,
                                           Model model)throws Exception{
        return FileUtil.download(filename);
    }

}



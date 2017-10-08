package com.sys.controller;

import com.sys.core.RecognitionEmotionService;
import com.sys.core.RecommendMusicService;
import com.sys.core.SpeechDecorderService;
import com.sys.service.UserService;
import com.sys.util.FileUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * description:
 * Created on 2017/9/19 11:15
 */
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

    /*@RequestMapping(value="/{formName}")
    public String loginForm(@PathVariable String formName){
        // 动态跳转页面
        return formName;
    }*/

    /**
     * Upload string.
     * 上传录音文件的方法 将文件保存到指定位置并且跳转到路径为recognitionEmotion的控制器方法
     * @param request       the request
     * @param multipartFile the multipart file
     * @param attributes    the attributes
     * @param session       the session
     * @return the string
     * @throws Exception the exception
     */
// 上传文件会自动绑定到MultipartFile中
    @RequestMapping(value="/upload",method= RequestMethod.POST)
    public String upload(HttpServletRequest request,
                         @RequestParam("file") MultipartFile multipartFile,
                         RedirectAttributes attributes,
                         HttpSession session) throws Exception{
        session.setAttribute("userSession",userService.getUserById(1));//获取当前会话里的user数据
        String silkFileName=multipartFile.getOriginalFilename(); // 得到上传时的文件名
        attributes.addAttribute("silkFileName",silkFileName);
        boolean success=FileUtil.upload(request,multipartFile,"silk");
        if(success){
            return "redirect:/recognitionEmotion";
        }else {
            return "error";
        }
    }

    /**
     * Download response entity.
     * 下载文件的方法
     * @param request  the request
     * @param filename the filename
     * @param model    the model
     * @return the response entity
     * @throws Exception the exception
     */
    @RequestMapping(value="/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request,
                                           @RequestParam("filename") String filename,
                                           Model model)throws Exception{
        return FileUtil.download(filename);
    }

}



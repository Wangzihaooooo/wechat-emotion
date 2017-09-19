package com.sys.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import com.sys.persistence.domain.Speech;
import com.sys.persistence.domain.User;
import com.sys.util.FileUtil;
import com.sys.util.PropertyUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * description:文件上传
 * Created on 2017/9/19 11:15
 **/
@Controller
public class FileUploadController{

    // 上传文件会自动绑定到MultipartFile中
    @RequestMapping(value="/upload",method= RequestMethod.POST)
    public String upload(HttpServletRequest request, @RequestParam("file") MultipartFile multipartFile) throws Exception{
        if(FileUtil.upload(multipartFile,"silk")){
            return "success";
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



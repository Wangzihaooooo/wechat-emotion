package com.sys.util;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;

/**
 * description:文件上传和下载工具
 * Created on 2017/9/19 12:59
 **/
public class FileUtil {

    public static Boolean upload(RedirectAttributes attributes, MultipartFile file, String fileType) throws Exception {
        if(fileType.equals("silk")){
            // 如果文件不为空，写入上传路径
            if(!file.isEmpty()){
                // 上传文件路径 F:\idea\weixin\target\weixin-1.0-SNAPSHOT\speech
                String dirPath=System.getProperty("speechPath");;
                // 得到上传时的文件名
                String filename = file.getOriginalFilename();
                if(filename.indexOf(".")>=1){
                    filename = filename.split("\\.")[2]+".silk";
                }
                attributes.addAttribute("silkFileName",filename);
                // 判断父目录的路径是否存在，如果不存在就创建一个
                File filepath = new File(dirPath,filename);
                if (!filepath.getParentFile().exists()) {
                    filepath.getParentFile().mkdirs(); }
                // 将上传文件保存到一个目标文件当中
                File silkFile=new File(dirPath+File.separator+ filename);
                //Runtime.getRuntime().exec("chmod 777 -R" + " "+dirPath+File.separator+filename);
                file.transferTo(silkFile);
                return true;
            }else{
                return false;
            }
        }else {
            return false;
        }
    }
    @RequestMapping(value="/download")
    public static ResponseEntity<byte[]> download(String filename)throws Exception{
        // 下载文件路径
        String path = System.getProperty("songPath");
        File file = new File(path+File.separator+ filename);
        HttpHeaders headers = new HttpHeaders();
        // 下载显示的文件名，解决中文名称乱码问题
        String downloadFielName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
        // 通知浏览器以attachment（下载方式）打开图片
        headers.setContentDispositionFormData("attachment", downloadFielName);
        // application/octet-stream ： 二进制流数据（最常见的文件下载）。
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // 201 HttpStatus.CREATED
        return new ResponseEntity<>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }
}

package com.sys.core;

import com.sys.util.Base64Util;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * description:对微信小程序录音文件silk格式先进行base64解密来解码成webn格式，
 *              再运用ffmpeg工具运行命令行将webn解码成wav格式
 * Created on 2017/9/18 19:55
 **/
@Service
public class SpeechDecorder {

    private static Logger log = Logger.getLogger(SpeechDecorder.class.getName());

    /**
     * Decode boolean.
     *
     * @param SilkFilePath the silk file path
     * @param WebnFilePath the webn file path
     * @param WavFilePath  the wav file path
     * @return the boolean
     */
    public Boolean decode(String SilkFilePath,String WebnFilePath,String WavFilePath){
        Boolean success=false;
        if(decodeToWebn(SilkFilePath,WebnFilePath)){
            if(decodeToWav(WebnFilePath,WavFilePath))
            {
                success=true;
                log.info("解码成功");
            }
            else {
                log.warn("webn to wav解码成功");
            }
        }else {
            log.warn("silk to webn解码成功");
        }
        return success;
    }

    private Boolean decodeToWebn(String SilkFilePath,String WebnFilePath) {
        Boolean success=false;
        try {
            String encoding = "utf-8";
            File file = new File(SilkFilePath);
            if (file.isFile() && file.exists()) { // 判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                StringBuilder lineTxt = new StringBuilder();
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    lineTxt.append(line); }
                read.close();

                String olddata = lineTxt.toString();
                olddata = olddata.replace("data:audio/webm;base64,", "");

                try {
                    File webmFile = new File(WebnFilePath);
                    byte[] bt = Base64Util.decode(olddata) ;
                    FileOutputStream in = new FileOutputStream(webmFile);
                    try {
                        in.write(bt, 0, bt.length);
                        in.close();
                        success=true;
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                log.warn("找不到指定的文件");
            }
        } catch (Exception e) {
            log.warn("读取文件内容出错");
            e.printStackTrace();
        }
        return success;
    }

    private Boolean decodeToWav(String WebnFilePath,String WavFilePath){
        Boolean success=false;
        try {
            String path="ffmpeg -i "+WebnFilePath+" -f wav "+WavFilePath ;
            Process ps = Runtime.getRuntime().exec(path);
            ps.waitFor();
            success=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
}

package com.sys.core;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import java.io.*;

/**
 * description:对微信小程序录音文件silk格式先进行base64解密来解码成webn格式，
 * 再运用ffmpeg工具运行命令行将webn解码成wav格式
 * Created on 2017/9/18 19:55
 */
@Service
public class SpeechDecorderService {
    private static Logger log = Logger.getLogger(SpeechDecorderService.class.getName());
    private Boolean success=false;//判断解码是否成功
    /**
     * Decode boolean.
     * decode方法依次调用decodeToWebn decodeToWav 方法进行解密解码
     * @param SilkFilePath the silk file path
     * @param WebnFilePath the webn file path
     * @param WavFilePath  the wav file path
     * @return the boolean
     */
    public Boolean decode(String SilkFilePath,String WebnFilePath,String WavFilePath){
        success=false;
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
    //调用Base64Util工具类来对silk进行base64解密
    private Boolean decodeToWebn(String SilkFilePath,String WebnFilePath) {
        success=false;
        try {
            String encoding = "utf-8";
            File file = new File(SilkFilePath);
            if (file.isFile() && file.exists()) { // 判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                StringBuilder lineTxt = new StringBuilder();
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    lineTxt.append(line);
                }
                read.close();

                String olddata = lineTxt.toString();
                olddata = olddata.replace("data:audio/webm;base64,", "");

                try {
                    File webmFile = new File(WebnFilePath);
                    //Runtime.getRuntime().exec("chmod 777 -R" + " "+WebnFilePath);
                    BASE64Decoder base64Decoder=new BASE64Decoder();
                    byte[] bt = base64Decoder.decodeBuffer(olddata) ;
                    //byte[] bt = Base64Util.decode(olddata) ;
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
    //调用配置了系统环境path的FFmpeg的工具来进行解码
    private Boolean decodeToWav(String WebnFilePath,String WavFilePath){
        success=false;
        try {
            String path="ffmpeg -i "+WebnFilePath+" -ar 16000 -f wav "+WavFilePath ;
            Process ps = Runtime.getRuntime().exec(path);
            ps.waitFor();
            File wavFile = new File(WavFilePath);
            wavFile.setExecutable(true);
            wavFile.setReadable(true);
            wavFile.setWritable(true);
            success=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
}

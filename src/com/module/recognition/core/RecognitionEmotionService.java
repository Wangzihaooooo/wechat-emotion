package com.module.recognition.core;

import com.sys.util.PropertyUtil;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
/**
 * description:
 * Created on 2017/9/16 11:07
 **/
@Service
public class RecognitionEmotionService {

    /**
     * 用于识别的情绪
     * @param  fileName
     * @return 返回的是int类型   -1--无法识别 0--angry 1--fear 2--happy 3--sad
     */
    public int recognitionEmotion(String fileName){
        int result = -1;//测试的结果
        String pyPath = PropertyUtil.getProperty("filePath.properties","recognitionPy.path")+"\\"+"Emotion.py";
        String speechPath = PropertyUtil.getProperty("filePath.properties","speech.path")+"\\"+fileName;
        Runtime run = Runtime.getRuntime();
        try {
            Process process = run.exec("python" +" "+ pyPath + " " + speechPath);
            InputStream in = process.getInputStream();
            BufferedReader input = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = input.readLine()) != null) {
                result = Integer.parseInt(line);
            }
            in.close();
            process.waitFor();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}

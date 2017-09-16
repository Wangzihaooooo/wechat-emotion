package com.module.recognition.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

/**
 * description:音乐随机不重复推荐算法
 * Created on 2017/9/14 21:08
 **/
public class RandomRecommend {
    private static  Logger log=Logger.getLogger(RandomRecommend.class.getName());

    /**
     * Recommend music list.
     *
     * @param begin     音乐数组的最小下标，一般为0
     * @param end       音乐数组的最小下标，一般为存放音乐的最大数目
     * @param randomSize 随机选取的音乐总数
     * @return the list
     */
    public List<Integer> recommendMusic (int begin,int end,int randomSize){
        //判断随机选取的范围的正确性
        if(randomSize<1||randomSize>(end-begin+1)){
            log.warning("随机选取的范围不合法");
            return null;
        } else {
            Random random=new Random();
            List<Integer> musicList=new ArrayList<Integer>();
            Integer randomNum;
            while(musicList.size()<randomSize){
                //获取随机数
                randomNum=random.nextInt(end-begin+1);
                //保证获取的随机数不重复
                if(musicList.contains(randomNum)){
                    musicList.add(randomNum);
                }
            }
            return musicList;
        }
    }
}

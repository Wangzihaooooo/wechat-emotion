package com.module.recognition.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

/**
 * description:随机不重复推荐算法
 * Created on 2017/9/14 21:08
 **/
public class RandomRecommendUtil {
    private static  Logger log=Logger.getLogger(RandomRecommendUtil.class.getName());

    /**
     * Recommend music list.
     *
     * @param begin     数组的最小下标，一般为0
     * @param end       数组的最大下标
     * @param randomSize 随机选取的数量
     * @return the list
     */
    public List<Integer> randomRecommend (int begin,int end,int randomSize){
        //判断随机选取的范围的正确性
        if(randomSize<1||randomSize>(end-begin+1)){
            log.warning("随机选取的范围不合法");
            return null;
        } else {
            Random random=new Random();
            List<Integer> randomList=new ArrayList<Integer>();
            int randomNum;
            while(randomList.size()<randomSize){
                //获取随机数
                randomNum=random.nextInt(end-begin+1);
                //保证获取的随机数不重复
                if(!randomList.contains(randomNum)){
                    randomList.add(new Integer(randomNum+begin));
                }
            }
            return randomList;
        }
    }
}

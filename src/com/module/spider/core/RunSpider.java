package com.module.spider.core;

/**
 * description:
 * Created on 2017/9/19 19:42
 **/
public class RunSpider {
    public void runMusicSpider(){
        try {
            String path="scrapy crawl MusicSpider" ;
            Process ps = Runtime.getRuntime().exec(path);
            ps.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

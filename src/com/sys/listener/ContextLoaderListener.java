package com.sys.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * description: 设置上下文监听器，初始化全局变量
 * Created on 2017/10/8 15:01
 **/
public class ContextLoaderListener implements ServletContextListener {

    //实现全局上下文初始化方法
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //获得全局变量
        ServletContext servletContext = servletContextEvent.getServletContext();
        //设置全局变量属性 获取各种文件的路径
        System.setProperty("warPath",servletContext.getRealPath("/"));
        System.setProperty("log4jPath",servletContext.getRealPath("/log/sys.log"));
        System.setProperty("speechPath",servletContext.getRealPath("/speech/"));
        System.setProperty("songPath",servletContext.getRealPath("/WEB-INF/song/"));
        System.setProperty("recognitionPyPath",servletContext.getRealPath("/WEB-INF/classes/com/module/recognition/pythonCode"));
    }

    //实现全局上下文销毁函数
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //实现
    }
}

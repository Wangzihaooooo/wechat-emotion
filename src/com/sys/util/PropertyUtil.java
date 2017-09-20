package com.sys.util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;
/**
 * description: properties配置文件获取工具类
 * Created on 2017/9/18 21:33
 **/
public class PropertyUtil {
    private static final Logger logger = LoggerFactory.getLogger(PropertyUtil.class);
    private static String propertyName;//配置文件的文件名
    private static Properties props;
    synchronized static private void loadProps(Properties properties,String propertyName){
        props=properties;
        InputStream in = null;
        try {
            //第一种，通过类加载器进行获取properties文件流
            in = PropertyUtil.class.getClassLoader().getResourceAsStream(propertyName);
            //第二种，通过类进行获取properties文件流
            //in = PropertyUtil.class.getResourceAsStream("/db-config.properties");
            props.load(in);
        } catch (FileNotFoundException e) {
            logger.error(propertyName+"文件未找到");
        } catch (IOException e) {
            logger.error("出现IOException");
        } finally {
            try {
                if(null != in) {
                    in.close();
                }
            } catch (IOException e) {
                logger.error(propertyName+"文件流关闭出现异常");
            }
        }
    }

    public static String getProperty(String propertyName,String key){
        Properties properties=new Properties();
        loadProps(properties,propertyName);
        return props.getProperty(key);
    }

}

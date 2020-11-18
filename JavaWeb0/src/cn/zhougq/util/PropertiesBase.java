package cn.zhougq.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author zhouganqing
 * @create 2020- 06- 14- 10:43
 */
public class PropertiesBase {
    //私有化静态对象（需在实例化之前,构造函数需要使用）
    private static Properties pps = new Properties();

    //懒汉模式
    //private PropertiesBase base;

    //饿汉模式（静态函数有且只执行一次构造函数）
    public static PropertiesBase base = new PropertiesBase();


    //构造函数私有化,不能被实例
    private PropertiesBase()
    {
        //加载properties对象(从文件读取加载)

        //文件路径(针对于项目相对路径)
        String path = "mysql.properties";
        //加载文件流
        InputStream stream = PropertiesBase.class.getClassLoader().getResourceAsStream(path);

        try {
            //文件流转换为properties对象
            pps.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //创建该类的实例（单列模式/懒汉模式）线程安全问题,性能低
    public synchronized static PropertiesBase getInstance(){
        if (base==null)
        {
            base = new PropertiesBase();
        }
        return  base;
    }

    public static String getKey(String key){

        return pps.getProperty(key);
    }
}

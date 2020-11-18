package cn.zhougq.Utils;

import com.mysql.cj.exceptions.ExceptionInterceptor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @author zhouganqing
 * @create 2020- 06- 22- 17:15
 */
public class MybatisUtil {
    //定义工厂,单列模式
    private static SqlSessionFactory sessionFactory;

    //初始化静态变量,静态代码块在类加载的时候执行,只会执行一次
    static {
        try {
            //读取xml文件,加载mybatis
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            //创建工厂
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
            //静态初始化异常
            //throw new ExceptionInInitializerError();
            throw new RuntimeException(e);
        }
    }

    //私有化构造函数，禁止外部实例化
    private MybatisUtil(){}

    public static SqlSession getSqlSession(boolean b){

        return sessionFactory.openSession(b);
    }

}

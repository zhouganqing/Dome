package cn.zhougq.Untils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author zhouganqing
 * @create 2020- 08- 10- 17:28
 */
public class HibernateUntil {
    private static Configuration cfg;//加载Hibernate配置文件
    private final static SessionFactory sf;

    private HibernateUntil(){}

    static {
        try {
            cfg = new Configuration().configure();//读取配置文件
            sf = cfg.buildSessionFactory();//获取session工厂
        }catch (HibernateException ex)
        {
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session currentSession()
    {
        return sf.getCurrentSession();
    }

}

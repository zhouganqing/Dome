package cn.zhougq.dao.impl;

import cn.zhougq.Untils.HibernateUntil;
import org.hibernate.Session;

/**
 * @author zhouganqing
 * @create 2020- 08- 10- 18:14
 */
public class BaseDao {

    public Session currentSession()
    {
        return HibernateUntil.currentSession();
    }
}

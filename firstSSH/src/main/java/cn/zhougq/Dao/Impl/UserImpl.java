package cn.zhougq.Dao.Impl;

import cn.zhougq.Dao.IUser;
import cn.zhougq.Entitys.SysUserList;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhouganqing
 * @create 2020- 08- 04- 10:00
 */
@Repository("userDao")
public class UserImpl implements IUser {

    @Resource(name="sqlSessionFactory")
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    @Override
    public List getUserList() {

        return sessionFactory.getCurrentSession().createQuery("from SysUserList").list();
    }

    @Transactional(readOnly = true)
    @Override
    public SysUserList getUserById(int id) {
        return sessionFactory.getCurrentSession().get(SysUserList.class,id);
    }
}

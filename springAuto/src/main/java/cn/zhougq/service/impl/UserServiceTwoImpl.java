package cn.zhougq.service.impl;

import cn.zhougq.dao.IUserDao;
import cn.zhougq.entitys.User;
import cn.zhougq.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhouganqing
 * @create 2020- 07- 18- 14:31
 */
/*Service注解业务层*/
@Service
public class UserServiceTwoImpl implements IUserService {

    private IUserDao userDao;

    /*setter注解*/
    @Autowired(required = false)
    @Qualifier("userDaoTwo")
    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(User user) {
        userDao.saveUser(user);
    }
}

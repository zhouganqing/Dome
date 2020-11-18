package cn.zhougq.service.impl;

import cn.zhougq.dao.IUserDao;
import cn.zhougq.entitys.User;
import cn.zhougq.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author zhouganqing
 * @create 2020- 07- 18- 14:31
 */
/*Service注解业务层*/
@Service
public class UserServiceThreeImpl implements IUserService {

    private IUserDao userDao;

    /*构造函数注解*/
    @Autowired(required = false)
    public UserServiceThreeImpl(@Qualifier("userDaoTwo")IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(User user) {
        userDao.saveUser(user);
    }
}

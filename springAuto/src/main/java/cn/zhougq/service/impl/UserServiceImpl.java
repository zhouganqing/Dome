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
public class UserServiceImpl implements IUserService {

    /*
    * Autowired 自动装载(实例化)
    * required = false 默认为true；装载不了会抛异常；
    * false不会异常空指针
    * Qualifier 接口有多个实现的时候指定对应实现类
    *
    * @Resource(name = "userDaoImpl")==Autowired+Qualifier
    * */
    @Autowired(required = false)
    @Qualifier("userDaoImpl")
    private IUserDao userDao;

    @Override
    public void addUser(User user) {
        userDao.saveUser(user);
    }
}

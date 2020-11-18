package cn.zhougq.controller;

import cn.zhougq.entitys.User;
import cn.zhougq.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;


/**
 * @author zhouganqing
 * @create 2020- 07- 18- 15:09
 */
/*Controller注解web层*/
@Controller
public class UserController {

    @Autowired
    @Qualifier("userServiceImpl")
    IUserService service;
    @Autowired
    User user;

    public void addUser()
    {
        user.setAge(20);
        service.addUser(user);
    }
}

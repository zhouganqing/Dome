package cn.zhougq.controller;

import cn.zhougq.entitys.User;
import cn.zhougq.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @author zhouganqing
 * @create 2020- 07- 18- 15:09
 */
/*Controller注解web层*/
@Controller
public class UserTwoController {

    /*
    * name=... 使用指定名称去注解
    * service 未指定name时,使用service名称去注解
    * IUserService 找不到对应名称时,通过类型去注解
    *
    * 还可以通过setter方式注解，原理同上
    * */
    @Resource(name = "userServiceThreeImpl")
    IUserService service;
    @Resource
    User user;

    public void addUser()
    {
        user.setAge(20);
        service.addUser(user);
    }
}

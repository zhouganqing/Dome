package cn.zhougq.controller;

import cn.zhougq.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouganqing
 * @create 2020- 10- 15- 17:47
 */

@RestController
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/")
    public String sayHello(String name)
    {
        return  userService.sayHello(name);
    }
}

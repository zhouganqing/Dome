package cn.zhougq.controller;

import cn.zhougq.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouganqing
 * @create 2020- 10- 16- 15:14
 */

@RestController
public class HelloController {
    @Autowired
    HelloService service;

    @GetMapping("/hello")
    public String sayHello(){
        return service.sayHello();
    }
}

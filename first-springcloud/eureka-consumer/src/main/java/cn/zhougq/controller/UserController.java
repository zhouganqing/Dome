package cn.zhougq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhouganqing
 * @create 2020- 10- 16- 16:39
 */

@RestController
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/say")
    public String Say(String name){
        String s = restTemplate.getForObject("http://EUREKA-PROVIDER/hello", String.class);
        return s + name;
    }
}

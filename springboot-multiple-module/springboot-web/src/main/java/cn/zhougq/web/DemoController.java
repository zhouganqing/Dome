package cn.zhougq.web;

import cn.zhougq.dao.entitys.UserInfo;
import cn.zhougq.service.IdemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouganqing
 * @create 2020- 09- 20- 11:25
 */

@RestController
public class DemoController {

    @Autowired
    private IdemoService service;

    @GetMapping("user/{id}")
    public UserInfo GetUserById(@PathVariable("id")Integer id)
    {
        return service.GetUserById(id);
    }
}

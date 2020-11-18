package cn.zhougq.controller;

import cn.zhougq.service.IAsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouganqing
 * @create 2020- 10- 14- 10:05
 */

@RestController
public class AsyncController {

    @Autowired
    IAsyncService iAsyncService;

    @GetMapping("/hello")
    public String hello()
    {
        iAsyncService.hello();
        return "主线程完成";
    }
}

package cn.zhougq.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author zhouganqing
 * @create 2020- 10- 16- 17:43
 */


//注册中心 生产者注册的服务名
@FeignClient(name = "${zhougq.name:EUREKA-PROVIDER}")
public interface UserService {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String hello();
}

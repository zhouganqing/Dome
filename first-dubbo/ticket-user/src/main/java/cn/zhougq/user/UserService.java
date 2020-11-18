package cn.zhougq.user;

import cn.zhougq.service.ITicketService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * @author zhouganqing
 * @create 2020- 10- 14- 18:04
 */

@Service
public class UserService {

    /*版本必须匹配*/
    @DubboReference(version = "1.0.0")
    ITicketService service;

    public String sayHello(String name){
        String tk = service.sayHello(name);
        System.out.println("========"+tk);
        return  tk;
    }
}

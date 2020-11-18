package cn.zhougq.service.impl;

import cn.zhougq.service.ITicketService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author zhouganqing
 * @create 2020- 10- 14- 16:53
 */

@DubboService(interfaceClass = ITicketService.class, version = "1.0.0")    //将服务发布出去
public class TicketImpl implements ITicketService {

    @Value("${dubbo.application.name}")
    private String serviceName;

    @Override
    public String sayHello(String name) {
        return String.format("[%s] : Hello, %s", serviceName, name);
    }
}

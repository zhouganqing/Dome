package cn.zhougq;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
*   1、将服务提供者注册到注册中心
*       1、引入渡dubbo和zkClient相关依赖 （dubbo和zk客户端版本必须匹配,否则冲突）
*       2、配置dubbo的扫描包和注册中心地址
*       3、使用@service发布服务
* */

//@EnableDubbo    //会扫描所有的包，从中找出dubbo的@Service标注的类,在配置文件写了
// @DubboComponentScan(basePackages = "cn.zhougq.service")  //只扫描指定的包
@SpringBootApplication
public class TicketServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketServiceApplication.class, args);
    }

}

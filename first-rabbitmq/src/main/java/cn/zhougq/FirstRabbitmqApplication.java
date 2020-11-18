package cn.zhougq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
* 自动配置
* 1、RabbitAutoConfiguration 自动配置类
* 2、ConnectionFactory 自动配置了连接工厂
* 3、RabbitTemplate  发送和接收消息的操作类
* 4、AmqpAdmin   系统管理功能组件
*    创建和删除Exchange,Queue,Binding
* 5、@EnableRabbit 开启基于注解的RabbitMq模式
* */
@EnableRabbit
@SpringBootApplication
public class FirstRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstRabbitmqApplication.class, args);
    }

}

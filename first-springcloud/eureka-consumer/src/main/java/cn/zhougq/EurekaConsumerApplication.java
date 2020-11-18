package cn.zhougq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/*
* 服务消费者
*
* RestTemplate ribbon+restTemplate方式消费
* */

@EnableDiscoveryClient  //开启发现服务功能
@SpringBootApplication
public class EurekaConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerApplication.class, args);
    }

    @LoadBalanced   //开启负载均衡机制
    @Bean
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }
}

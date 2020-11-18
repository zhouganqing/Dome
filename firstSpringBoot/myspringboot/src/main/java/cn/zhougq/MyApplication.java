package cn.zhougq;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zhouganqing
 * @create 2020- 08- 23- 11:26
 */

@SpringBootApplication
@MapperScan(basePackages = {"cn.zhougq.mappers"})
public class MyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class,args);
    }
}

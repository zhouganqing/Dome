package cn.zhougq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan(value = "cn.zhougq.mapper")
@SpringBootApplication
@EnableCaching
public class SpringbootCache01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCache01Application.class, args);
    }

}

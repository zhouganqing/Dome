package cn.zhougq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

//该指令用于加载spring的xml配置文件,springboot不推荐使用该方式
//@ImportResource(locations = {"classpath:beans.xml"})

//注解mapper,扫描对应的包下所有mapper;给包下所有类加@mapper标记
@MapperScan(value = "cn.zhougq.mapper")
@SpringBootApplication
public class SpringBootFirstApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFirstApplication.class, args);
    }

}

package cn.zhougq.controller;

import cn.zhougq.Entitys.YamlEntity;
import cn.zhougq.mappers.NewMapper;
import cn.zhougq.pojo.NewsMod;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhouganqing
 * @create 2020- 08- 23- 10:26
 */

@RestController
@Api("欢迎页面")
public class HelloController {

    /*注解@Value映射yml对象*/
    @Value("${yaml.str}")
    private String str;
    @Value("${yaml.num}")
    private Integer num;


    @Autowired
    YamlEntity yamlEntity;

    @Autowired
    NewMapper newMapper;


    /*
    *设置web访问地址
    * */
    @GetMapping("show")
    @ApiOperation("say Hello")
    private String HelloMsg()
    {

        return  "Hello Spring Boot;\r\n" + yamlEntity.toString();
    }
}

package cn.zhougq;

import cn.zhougq.config.yamlConfig;
import cn.zhougq.config.yamlProperties;
import cn.zhougq.entity.NewsMod;
import cn.zhougq.mapper.NewsModMapper;
import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

//使用spring启动测试,可以类似编码一样自动注解
@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootFirstApplicationTests {

    Logger log = LoggerFactory.getLogger(SpringBootFirstApplicationTests.class);

    @Autowired
    private yamlConfig yaml;

    @Autowired
    private yamlProperties yaml2;

    @Autowired
    private ApplicationContext ioc;

    @Test
    public void contextLoads() {
        System.out.println(yaml.toString());
        //System.out.println(yaml2.getStr());

        //xml文件写入bean
        //System.out.println(ioc.containsBean("testBean"));

        //@Bean注解配置
        //System.out.println(ioc.containsBean("testB"));

    }

    @Test
    public void loggerRead()
    {
        //日志级别,从低到高,可以调整日志级别,日志只会在这个级别及以后的级别生效
        log.trace("trace");
        log.debug("debug");
        //springboot默认级别info
        log.info("info");
        log.warn("warn");
        log.error("error");
    }

    //引用JDBC包
    /*@Autowired
    private DataSource ds;
    @Test
    public void dsLoad() {
        //默认使用HikariDataSource数据源
        System.out.println(ds.getClass());
    }*/

    @Autowired
    private DruidDataSource ds;
    @Test
    public void DruidLoad() {
        //默认使用DruidDataSource数据源
        System.out.println(ds.getClass());
    }

    @Autowired
    private NewsModMapper newsMod;
    @Test
    public void newsModeLoad() {
        NewsMod info = newsMod.getNewsModById(1);
        log.info("=========="+info.toString());
    }

}

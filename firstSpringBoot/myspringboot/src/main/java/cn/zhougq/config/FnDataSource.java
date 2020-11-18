package cn.zhougq.config;

import cn.zhougq.config.properties.DruidProperties;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhouganqing
 * @create 2020- 08- 23- 18:28
 */

//@Configuration
public class FnDataSource {

    /*@Autowired
    DruidProperties druidProperties;

    @Bean(name = "fnDataSource")
    public DruidDataSource fnDataSource(DataSourceProperties properties) {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        return dataSource;
    }*/
}

package cn.zhougq.config;

import cn.zhougq.config.dataProperties.FnDruidProperties;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouganqing
 * @create 2020- 08- 29- 15:57
 * 自定义DruidDataSource
 */

@Configuration
public class DruidSourceConfig {

    @Autowired
    FnDruidProperties druidProperties;

    //在yaml文件配置数据源,不需要配置自定义DataSource，Springboot兼容druid数据源
    //如果在yaml自定义标签配置了数据源可以使用ConfigurationProperties的配置方式
    @ConfigurationProperties(prefix = "spring.datasource.fn")
    @Bean(name = "fnDataSource")
    public DruidDataSource fnDataSource(DataSourceProperties properties) {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        return dataSource;
    }

    //配置druid监控,默认访问地址：http://localhost:8080/druid/
    //1、配置servlet的管理后台,ServletRegistrationBean 注册一个servlet
    @Bean
    public ServletRegistrationBean statViewServlet(){

        ServletRegistrationBean bean=new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String,String> map =new HashMap<>();
        map.put("loginUsername","admin");//页面登录的用户名密码
        map.put("loginPassword","admin");
        //map.put("allow","localhost");//允许谁访问,本地访问,默认空值,允许所有
        //map.put("deny","192.168.0.1");//拒绝谁访问,指定IP
        bean.setInitParameters(map);
        return bean;
    }

    //2、配置一个web监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter()
    {
        FilterRegistrationBean filter=new FilterRegistrationBean();
        filter.setFilter(new WebStatFilter());

        //配置WebStatFilter下的参数
        Map<String,String> map =new HashMap<>();
        map.put("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");//排除静态资源的监控和druid监控本身
        map.put("sessionStatEnable","true");
        map.put("sessionStatMaxCount","100");
        filter.setInitParameters(map);

        filter.setUrlPatterns(Arrays.asList("/*"));//监控根目录下的所有资源

        return filter;

    }
}

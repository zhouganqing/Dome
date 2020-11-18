package cn.zhougq.config;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhouganqing
 * @create 2020- 08- 29- 18:16
 */

@Configuration
public class MyBatisConfig {

    @Bean
    public ConfigurationCustomizer configurationCustomizer()
    {
        return  new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                //设置驼峰命名规则 数据库user_name== 实体类userName; 查询自动映射实体
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}

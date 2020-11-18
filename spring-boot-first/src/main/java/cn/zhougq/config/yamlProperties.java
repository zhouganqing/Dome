package cn.zhougq.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author zhouganqing
 * @create 2020- 08- 28- 9:28
 *
 * 使用PropertySource加载配置文件,映射所有属性
 */
@PropertySource(value = {"classpath:yamlConfig.properties"})
@Component
@ConfigurationProperties(prefix = "yaml2")
public class yamlProperties {
    private String str; // 普通字符串

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}

package cn.zhougq.redisson.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhouganqing
 * @create 2020- 09- 15- 20:35
 *
 * redis单机参数
 */

@ConfigurationProperties(prefix = "spring.redis")
@Configuration
public class RedisSingleProperties {
    private String host;
    private String port;
    private String password;
    private Integer timeout;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }
}

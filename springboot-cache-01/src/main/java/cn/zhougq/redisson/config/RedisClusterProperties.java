package cn.zhougq.redisson.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

/**
 * @author zhouganqing
 * @create 2020- 09- 15- 20:34
 *
 *redis 集群
 */

@ConfigurationProperties(prefix = "spring.redis")
@Configuration
public class RedisClusterProperties {
    private Map<String, List<String>> cluster;
    private String password;
    private int timeout;

    public Map<String, List<String>> getCluster() {
        return cluster;
    }

    public void setCluster(Map<String, List<String>> cluster) {
        this.cluster = cluster;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}

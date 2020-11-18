package cn.zhougq.redisson.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhouganqing
 * @create 2020- 09- 15- 19:47
 *
 * redisson 配置文件，替换默认RedissonProperties文件
 */

@ConfigurationProperties(prefix = "spring.redisson")
@Configuration
public class RedissonProperties {

    private boolean redissonOpen;
    private boolean iscluster;
    private Integer scanInterval;
    private Integer failedAttempts;
    private Integer reconnectionTimeout;
    private Integer retryInterval;
    private Integer retryAttempts;
    private Integer timeout;
    private Integer connectTimeout;
    private Integer idleConnectionTimeout;
    private Integer masterConnectionPoolSize;
    private Integer slaveConnectionMinimumIdleSize;

    public boolean isRedissonOpen() {
        return redissonOpen;
    }

    public void setRedissonOpen(boolean redissonOpen) {
        this.redissonOpen = redissonOpen;
    }

    public boolean isIscluster() {
        return iscluster;
    }

    public void setIscluster(boolean iscluster) {
        this.iscluster = iscluster;
    }

    public Integer getScanInterval() {
        return scanInterval;
    }

    public void setScanInterval(Integer scanInterval) {
        this.scanInterval = scanInterval;
    }

    public Integer getFailedAttempts() {
        return failedAttempts;
    }

    public void setFailedAttempts(Integer failedAttempts) {
        this.failedAttempts = failedAttempts;
    }

    public Integer getReconnectionTimeout() {
        return reconnectionTimeout;
    }

    public void setReconnectionTimeout(Integer reconnectionTimeout) {
        this.reconnectionTimeout = reconnectionTimeout;
    }

    public Integer getRetryInterval() {
        return retryInterval;
    }

    public void setRetryInterval(Integer retryInterval) {
        this.retryInterval = retryInterval;
    }

    public Integer getRetryAttempts() {
        return retryAttempts;
    }

    public void setRetryAttempts(Integer retryAttempts) {
        this.retryAttempts = retryAttempts;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public Integer getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(Integer connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public Integer getIdleConnectionTimeout() {
        return idleConnectionTimeout;
    }

    public void setIdleConnectionTimeout(Integer idleConnectionTimeout) {
        this.idleConnectionTimeout = idleConnectionTimeout;
    }

    public Integer getMasterConnectionPoolSize() {
        return masterConnectionPoolSize;
    }

    public void setMasterConnectionPoolSize(Integer masterConnectionPoolSize) {
        this.masterConnectionPoolSize = masterConnectionPoolSize;
    }

    public Integer getSlaveConnectionMinimumIdleSize() {
        return slaveConnectionMinimumIdleSize;
    }

    public void setSlaveConnectionMinimumIdleSize(Integer slaveConnectionMinimumIdleSize) {
        this.slaveConnectionMinimumIdleSize = slaveConnectionMinimumIdleSize;
    }
}

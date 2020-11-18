package cn.zhougq.redisson.lockBasic;


import cn.zhougq.redisson.config.RedisClusterProperties;
import cn.zhougq.redisson.config.RedisSingleProperties;
import cn.zhougq.redisson.config.RedissonProperties;
import org.apache.commons.lang3.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author zhouganqing
 * @create 2020- 09- 15- 20:32
 *
 *
 * 连接Redisson
 */

@Component
public class RedissonConnector {

    private static final String CLUSTER_NODES = "nodes";
    private static final String REDIS_PREFIX = "redis://";
    private static final String COLON_SYMBOL = ":";


    private RedissonClient redisson;
    @Autowired
    private RedissonProperties redissonProperties;
    @Autowired
    private RedisClusterProperties redisClusterParam;
    @Autowired
    private RedisSingleProperties redisSingleProperties;

    /*
    *@PostConstruct该注解被用来修饰一个非静态的void（）方法
    *@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器执行一次。
    *@PostConstruct在构造函数之后执行，init（）方法之前执行
    * 该注解的方法在整个Bean初始化中的执行顺序：
    * Constructor(构造方法) -> @Autowired(依赖注入) -> @PostConstruct(注释的方法)
    * */
    @PostConstruct
    public void init() {
        if(redissonProperties != null && redissonProperties.isRedissonOpen()) {
            Config config = new Config();
            //是否开启集群模式
            if(redissonProperties.isIscluster()) {
                // 集群扫描间隔时间
                ClusterServersConfig useClusterServers = config.useClusterServers();
                List<String> cluster = redisClusterParam.getCluster().get(CLUSTER_NODES);
                for(String str : cluster) {
                    useClusterServers.addNodeAddress(REDIS_PREFIX + str);
                }
                if(StringUtils.isNoneBlank(redisClusterParam.getPassword())) {
                    useClusterServers.setPassword(redisClusterParam.getPassword());
                }
                useClusterServers.setScanInterval(redissonProperties.getScanInterval())
                        .setRetryAttempts(redissonProperties.getRetryAttempts())
                        .setRetryAttempts(redissonProperties.getRetryAttempts())
                        .setRetryInterval(redissonProperties.getRetryInterval())
                        .setTimeout(redissonProperties.getTimeout())
                        .setConnectTimeout(redissonProperties.getConnectTimeout())
                        .setIdleConnectionTimeout(redissonProperties.getIdleConnectionTimeout())
                        .setMasterConnectionPoolSize(redissonProperties.getMasterConnectionPoolSize())
                        .setSlaveConnectionMinimumIdleSize(redissonProperties.getSlaveConnectionMinimumIdleSize());
            } else {
                SingleServerConfig useSingleServer = config.useSingleServer();
                useSingleServer.setAddress(REDIS_PREFIX+redisSingleProperties.getHost()+COLON_SYMBOL+redisSingleProperties.getPort());
                if(StringUtils.isNoneBlank(redisSingleProperties.getPassword())) {
                    useSingleServer.setPassword(redisSingleProperties.getPassword());
                }
                useSingleServer
                        .setRetryInterval(redissonProperties.getRetryInterval())
                        .setRetryAttempts(redissonProperties.getRetryAttempts())
                        .setTimeout(redissonProperties.getTimeout())
                        .setConnectTimeout(redissonProperties.getConnectTimeout())
                        .setIdleConnectionTimeout(redissonProperties.getIdleConnectionTimeout());
            }
            redisson = Redisson.create(config);
        }
    }

    @Bean
    public RedissonClient getClient() {
        return redisson;
    }
}

package cn.zhougq.config;


import cn.zhougq.entitys.NewsInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

/**
 * @author zhouganqing
 * @create 2020- 09- 11- 16:20
 *
 * RedisAutoConfiguration  按照Redis默认配置修改
 * 修改序列化 为json  一般不这样配置
 *
 * 配置cache缓存为Redis
 */

@Configuration
public class MyRedisConfig{

    @Bean
    public RedisTemplate<Object, NewsInfo> NewsRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, NewsInfo> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<NewsInfo> ser = new Jackson2JsonRedisSerializer<NewsInfo>(NewsInfo.class);
        template.setDefaultSerializer(ser);
        return template;
    }
}

package cn.zhougq.redis.config;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author zhouganqing
 * @create 2020- 09- 11- 17:21
 */

@Configuration
//@EnableCaching  //开启注解
public class RedisConfig {

    /**
     * retemplate相关配置
     * @param factory
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {

        RedisTemplate<String, Object> template = new RedisTemplate<>();
        // 配置连接工厂
        template.setConnectionFactory(factory);

        ObjectMapper om = new ObjectMapper();
        // 指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 禁用遇到未知属性抛出异常
        om.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // 对于空的对象转json的时候不抛出错误
        om.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);


        /*
        Json序列化：空间占用小，包括GenericJackson2JsonRedisSerializer和Jackson2JsonRedisSerializer 两种，
        其中GenericJackson2JsonRedisSerializer无需为各种类型单独定义Bean（默认使用JDK的序列化方式）
        */
        RedisSerializer<Object> jacksonSeial = new GenericJackson2JsonRedisSerializer(om);

        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        // value序列化方式采用jackson
        template.setValueSerializer(jacksonSeial);
        // key采用String的序列化方式
        template.setKeySerializer(stringRedisSerializer);
        // hash的key也采用String的序列化方式
        template.setHashKeySerializer(stringRedisSerializer);
        // hash的value序列化方式采用jackson
        template.setHashValueSerializer(jacksonSeial);
        template.afterPropertiesSet();

        return template;
    }

}

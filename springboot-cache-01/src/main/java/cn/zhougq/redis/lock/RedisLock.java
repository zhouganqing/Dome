package cn.zhougq.redis.lock;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhouganqing
 * @create 2020- 09- 16- 17:47
 *
 * redis 锁注解
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RedisLock {
    String key();

    int waitTime() default 5;//秒为单位

    int leaseTime() default 30;//秒为单位
}
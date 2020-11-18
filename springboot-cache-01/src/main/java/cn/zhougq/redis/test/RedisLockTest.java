package cn.zhougq.redis.test;

import cn.zhougq.redis.lock.RedisLock;
import cn.zhougq.redisson.lock.RedissonLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author zhouganqing
 * @create 2020- 09- 16- 18:22
 */

@Component
public class RedisLockTest {
    private static Integer ii=0;

    @RedissonLock(businessType = "springboo-cache-01:entry:testLock",lockKey={"key.value"})
    public  void  testLock(String key){
        //System.out.println(key);
        ii++;
        System.out.println(Thread.currentThread().getName()+"====抢到锁了"+ii);
    }

    @RedisLock(key="#key")
    public  void  testRedisLock(String key){
        //System.out.println(key);
        ii++;
        System.out.println(Thread.currentThread().getName()+"====抢到锁了"+ii);
    }

    @RedisLock(key="#key")
    public  void  testRedisLockI(String key,int i){
        //System.out.println(key);
        //递归,重入锁测试
        i++;
        if (i<10) {
            System.out.println(Thread.currentThread().getName()+"====抢到锁了"+i);
            testRedisLockI(key, i);
        }
    }

    @RedissonLock(businessType = "springboo-cache-01:entry:testLock",lockKey={"key.value"})
    public  void  testRedisLockII(String key,int i){
        //System.out.println(key);
        //递归,重入锁测试
        i++;
        if (i<10) {
            System.out.println(Thread.currentThread().getName()+"====抢到锁了"+i);
            testRedisLockII(key, i);
        }
    }
}

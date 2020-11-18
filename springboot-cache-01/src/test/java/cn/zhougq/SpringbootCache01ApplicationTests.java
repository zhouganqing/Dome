package cn.zhougq;

import cn.zhougq.entitys.NewsInfo;
import cn.zhougq.mapper.NewsMapper;
import cn.zhougq.redis.lock.RedisLock;
import cn.zhougq.redis.test.RedisLockTest;
import cn.zhougq.redisson.lock.RedissonLock;
import cn.zhougq.redisson.lockBasic.DistributedLocker;
import cn.zhougq.redis.util.RedisService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.locks.Lock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootCache01ApplicationTests {

    @Autowired
    NewsMapper newsMapper;

    /*操作k-v都是对象*/
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RedisTemplate<Object,NewsInfo> newsRedisTemplate;

    /*操作k-v都是字符串*/
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void stringRedis() {
        stringRedisTemplate.opsForValue().set("msg","hello");
        System.out.println("==="+stringRedisTemplate.opsForValue().get("msg"));

        stringRedisTemplate.opsForList().leftPush("myList","dog");
        stringRedisTemplate.opsForList().leftPush("myList","cat");
        System.out.println("===="+stringRedisTemplate.opsForList().rightPop("myList"));
    }

    @Test
    public void redisTemp() {
        NewsInfo info = newsMapper.getNewsInfoById(1);

        //默认JDK序列化
        //redisTemplate.opsForValue().set("info",info);

        //使用Json序列化,不推荐使用该方式,通常直接转json后存入redis
        newsRedisTemplate.opsForValue().set("info1",info);
        System.out.println("==="+redisTemplate.opsForValue().get("info1"));
    }

    @Test
    public void contextLoads() {
        NewsInfo info = newsMapper.getNewsInfoById(1);
        System.out.println(info.toString());
    }

    @Autowired
    RedisService redisService;

    @Test
    public void redisTemplateTest() {
        //redis 存储字符串
        //redisService.setStr("myStr","123",20);

        NewsInfo info = newsMapper.getNewsInfoById(1);
        //redis 存储实体(实体会转成json)
        redisService.setJson("myMap",info);
        //获取key值并转成实体
        System.out.println("=========="+redisService.getJson("myMap",NewsInfo.class).toString());
    }


    @Autowired
    RedisLockTest testLock;
    @Test
    public void redissonLocker(){
        //NewsInfo info = newsMapper.getNewsInfoById(1);
        testLock.testLock("myRedissonLock");
        testLock.testRedisLock("mylock");

    }

}

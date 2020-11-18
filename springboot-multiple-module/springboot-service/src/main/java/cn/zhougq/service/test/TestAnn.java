package cn.zhougq.service.test;

import cn.zhougq.service.annotation.ImyAnn;
import cn.zhougq.service.annotation.MyAnnInfo;
import org.springframework.stereotype.Component;

/**
 * @author zhouganqing
 * @create 2020- 09- 21- 15:41
 */

@Component
public class TestAnn {

    @ImyAnn(key="#key")
    public  void  testLock(String key){
        System.out.println(Thread.currentThread().getName()+"====抢到锁了");
    }

    @ImyAnn(key="#info.key")
    public  void  testLock(MyAnnInfo info){
        System.out.println(Thread.currentThread().getName()+"====抢到锁了");
    }
}

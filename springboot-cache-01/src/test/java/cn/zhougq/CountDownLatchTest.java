package cn.zhougq;

import cn.zhougq.redis.test.RedisLockTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhouganqing
 * @create 2020- 09- 17- 9:45
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountDownLatchTest {

    @Autowired
    RedisLockTest testLock;

    /**
     * 模拟client_num个客户端同时访问
     */
    private static int clientNum = 10;
    private static int threadsNum = 3;

    /**
     * 计数器
     */
    final static CountDownLatch doneSignal = new CountDownLatch(clientNum);

    /**
     * 并发抢锁测试
     * */
    @Test
    public void countDownLatchLoad()
    {
        //非线程池跑
        for(int i=0 ; i< clientNum; i++) {
            new Thread(()-> {
                try {
                    //线程等待,等计数器为0在执行
                    doneSignal.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //打印线程信息
                System.out.println(Thread.currentThread().getName()+"=开始抢锁");
                //抢锁
                testLock.testLock("myRedissonLock");
                //testLock.testRedisLock("myRedis");
            }).start();
            //计数器-1
            doneSignal.countDown();
        }
        //主线程堵塞,等待子线程执行完成
        try {
            //等待10秒
            Thread.sleep(1000*2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 线程池并发抢锁测试
     * */
    @Test
    public void countDownLatchPoolLoad()
    {
        /**
         * 建立线程池
         */
        ExecutorService exec = Executors.newFixedThreadPool(threadsNum);
        for(int i=0 ; i< clientNum; i++){
            exec.execute(new Thread(()->{
                try {
                    doneSignal.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //打印线程信息
                System.out.println(Thread.currentThread().getName()+"=开始抢锁");
                //抢锁
                //testLock.testLock("myRedissonLock");
                testLock.testRedisLock("myRedis");
            }));
            doneSignal.countDown();
        }

        try {
            //等待10秒
            Thread.sleep(1000*2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
    * 可重入锁测试
    * */
    @Test
    public void OverLoad(){
        //testLock.testRedisLockI("MyOver",0);
        testLock.testRedisLockII("MyOver",0);
    }
}

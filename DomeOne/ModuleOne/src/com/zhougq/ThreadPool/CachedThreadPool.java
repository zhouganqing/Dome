package com.zhougq.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhouganqing
 * @create 2020- 06- 08- 16:40
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        cacheThreadPool();
    }
    /**
     * 1.创建一个可缓存的线程池。如果线程池的大小超过了处理任务所需要的线程，那么就会回收部分空闲（60秒不执行任务）的线程
     * 2.当任务数增加时，此线程池又可以智能的添加新线程来处理任务
     * 3.此线程池不会对线程池大小做限制，线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小
     * 4.（线程无界限；无队列）
     * CorePoolSize:0       核心线程数
     * MaximumPoolSize:Integer.MAX_VALUE     最大线程数
     * KeepAliveTime： 60L, TimeUnit.SECONDS, 线程空闲60秒会回收销毁
     * new SynchronousQueue<Runnable>() 有空闲线程给空闲线程执行，没有空闲线程则新开线程执行
     * newCachedThreadPool将corePoolSize设置为0，将maximumPoolSize设置为Integer.MAX_VALUE，使用的SynchronousQueue，也就是说来了任务就创建线程运行，当线程空闲超过60秒，就销毁线程
     */
    public static void cacheThreadPool() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        System.out.println("线程池之前执行");
        for (int i = 1; i <= 100; i++) {
            int ii = i;
            try {
                Thread.sleep(ii*1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //线程添加进去后会被马上执行
            cachedThreadPool.execute(()->ThreadFun(ii));
        }
        cachedThreadPool.shutdown();
        System.out.println("线程池之后执行");

    }

    public static void ThreadFun(int ii)
    {
        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程名称：" + Thread.currentThread().getName() + "，执行" + ii);
    }
}

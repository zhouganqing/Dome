package com.zhougq.ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouganqing
 * @create 2020- 06- 09- 16:48
 */
public class ThreadPoolExecutorDome {
    public static void main(String[] args) {
        //自定义线程池
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3,10,
                200, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(5));

        for (int i = 0; i < 20; i++) {
            int ii =i;
            pool.execute(()->ThreadFun(ii));
            //线程池需要执行的任务数量
            pool.getTaskCount();
            //活动的线程数
            pool.getActiveCount();
            System.out.println("线程池中线程数目："+pool.getPoolSize()+"，队列中等待执行的任务数目："+
                    pool.getQueue().size()+"，已执行的任务数目："+pool.getCompletedTaskCount());
        }
        pool.allowCoreThreadTimeOut(true);
        pool.allowsCoreThreadTimeOut();
        //尝试关闭线程池
        pool.shutdown();

    }

    private static void ThreadFun(int ii) {
        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程名称：" + Thread.currentThread().getName() + "，执行" + ii);
    }

}

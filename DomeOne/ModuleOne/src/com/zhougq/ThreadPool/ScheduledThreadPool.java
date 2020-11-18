package com.zhougq.ThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouganqing
 * @create 2020- 06- 09- 9:37
 */
public class ScheduledThreadPool {
    public static void main(String[] args) {
        newScheduledThreadPool();
    }

     /**
      * 创建一个定长线程池，支持定时及周期性任务执行。延迟执行
      * 无界延迟阻塞队列
      * 核心线程有界限,最大线程无界限；默认优先级队列,无界限；哪个延时少先执行哪个任务
      * 因为队列无界限，最大线程用不上；
     */
    static void newScheduledThreadPool()
    {
        //需指定核心线程大小
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
        Executors.newWorkStealingPool();

        //执行延迟任务(Runnable,延迟时间,延迟单位)
        pool.schedule(()->Thread2(),3,TimeUnit.SECONDS);


        //执行延迟任务(Runnable,延迟时间,循环时间,延迟单位)
        Runnable rb3 = ()->Thread3();
        pool.scheduleAtFixedRate(rb3,3,3,TimeUnit.SECONDS);

        //执行普通任务
        for (int i = 0; i < 5; i++) {
            pool.execute(()->Thread1());
        }
    }

    //普通任务
    static void Thread1(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程"+Thread.currentThread().getName()+"执行：普通任务");
    }

    //延迟3秒执行任务
    static void Thread2(){
        System.out.println("线程"+Thread.currentThread().getName()+"执行：延迟3秒执行任务");
    }

    //延迟3秒后，每3秒执行一次任务
    static void Thread3(){
        System.out.println("线程"+Thread.currentThread().getName()+"延迟3秒后，每3秒执行一次任务");
    }
}

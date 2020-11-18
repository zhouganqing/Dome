package com.zhougq.ThreadPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author zhouganqing
 * @create 2020- 06- 09- 15:33
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        newFixedThreadPool();
    }

    /**
     * 1.创建固定大小的线程池。每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小<br>
     * 2.线程池的大小一旦达到最大值就会保持不变，如果某个线程因为执行异常而结束，那么线程池会补充一个新线程<br>
     * 3.因为线程池大小为3，每个任务输出index后sleep 2秒，所以每两秒打印3个数字，和线程名称<br>
     * 4.线程有界限,默认核心线程==最大线程；默认队列无界限;空闲时间为0,不会回收核心线程
     * newFixedThreadPool创建的线程池corePoolSize和maximumPoolSize值是相等的，它使用的LinkedBlockingQueue
     */
    static void newFixedThreadPool() {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            int ii =i;
            //不带返回参数的线程池
            //pool.execute(()->ThreadFun(ii));

            //带返回参数的线程池
            Future<String> future = pool.submit(()->{
                return ThreadFun2(ii);
            });
            try {
                //future.get 会阻塞当前线程,需等待有返回值才会执行
                System.out.println("返回参数："+future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    public static void ThreadFun(int ii) {
        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程名称：" + Thread.currentThread().getName() + "，执行" + ii);
    }

    public static String ThreadFun2(int ii) {
        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程名称：" + Thread.currentThread().getName() + "，执行" + ii);
        return Thread.currentThread().getName()+ Math.random();
    }
}

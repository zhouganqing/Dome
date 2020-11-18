package com.zhougq.ThreadPool;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhouganqing
 * @create 2020- 06- 09- 14:34
 */
public class WorkStealingPool {
    public static void main(String[] args) {
        newWorkStealingPool();
        try {
            // 因为work stealing 是deamon线程,即后台线程,精灵线程,守护线程
            // 所以当main方法结束时, 此方法虽然还在后台运行,但是无输出
            // 可以通过对主线程阻塞解决
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * WorkStealingPool(JDK1.8之后新增)
     * 工作窃取线程池,并行线程池,不会在乎执行顺序，抢占式执行
     *
     * 假设共有三个线程同时执行, A, B, C
     * 当A,B线程池尚未处理任务结束,而C已经处理完毕,则C线程会从A或者B中窃取任务执行,这就叫工作窃取
     * 假如A线程中的队列里面分配了5个任务，而B线程的队列中分配了1个任务，当B线程执行完任务后，它会主动的去A线程中窃取其他的任务进行执行
     * WorkStealingPool 背后是使用 ForkJoinPool实现的
     */
    static void newWorkStealingPool()
    {
        //parallelism：线程并发的数量,默认CPU 核数 Runtime.getRuntime().availableProcessors()
        ExecutorService pool = Executors.newWorkStealingPool(5);
        for (int i = 0; i < 10; i++) {
            int ii = i;
            pool.execute(()->ThreadFun(ii));
        }

    }

    public static void ThreadFun(int ii) {
        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程名称：" + Thread.currentThread().getName() + "，执行" + ii);
    }
}

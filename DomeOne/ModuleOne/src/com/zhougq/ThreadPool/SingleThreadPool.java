package com.zhougq.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhouganqing
 * @create 2020- 06- 08- 18:15
 */
public class SingleThreadPool {
    public static void main(String[] args) {
        singleTheadPoolTest();
    }

    /**
     * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，
     * 保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
     * CorePoolSize:0       核心线程数：1
     * MaximumPoolSize     最大线程数：1
     * KeepAliveTime： 0L, TimeUnit.MILLISECONDS, 0毫秒，线程存活时间是无限的
     * new LinkedBlockingQueue<Runnable>() 链表的先进先出队列，默认Integer.MAX_VALUE
     * newSingleThreadExecutor将corePoolSize和maximumPoolSize都设置为1，也使用的LinkedBlockingQueue；
     * 无界阻塞队列
     */
    public static void singleTheadPoolTest() {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            int ii = i;
            //pool.execute(() -> System.out.println(Thread.currentThread().getName() + "=>" + ii));
            pool.execute(()->ThreadFun(ii));
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

}

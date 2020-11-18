package com.zhougq.Thread.Lock;

/**
 * @author zhouganqing
 * @create 2020- 05- 28- 10:32
 */
public class SynchronizedTest {

    private final Object lockB=new Object();

    //wait阻塞线程,匿名线程
    public void  WaitThread() {
        //JDK1.8之前；无参数，无返回值
        new Thread(new Runnable() {
            @Override
            public void run() {
                //获取当前线程ID
                System.out.println("无参数线程："+Thread.currentThread().getId());
            }
        }).start();

        //JDK1.8新写法
        new Thread(()->{
            //获取当前线程ID
            System.out.println("无参数线程："+Thread.currentThread().getId());
        }).start();
        new Thread(()->ThreadA()).start();
        new Thread(()->ThreadA()).start();
        new Thread(()->ThreadB()).start();

    }

    //线程A
    private void ThreadA()
    {
        Thread thread = Thread.currentThread();
        System.out.println("线程"+thread.getId()+"wait...");
        synchronized (lockB) {
            try {
                //阻塞并释放锁
                lockB.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("我胡汉三又回来了!!!");
        System.out.println("线程"+thread.getId()+"结束");
    }

    //线程B
    private void ThreadB(){
        Thread thread = Thread.currentThread();
        System.out.println("线程"+thread.getId()+"准备唤醒ThreadA");

        synchronized (lockB) {
            //唤醒ThreadA,但未释放锁,需要等该线程执行完成后才会释放锁,被唤醒的线程才能执行
            lockB.notifyAll();
            try {
                System.out.println("线程" + thread.getId() + "休息5秒");
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("线程"+thread.getId()+"结束");
    }
}

package com.zhougq.Thread.Lock;

/**
 * @author zhouganqing
 * @create 2020- 06- 10- 16:25
 */
public class LockTestMain {
    public static void main(String[] args) {
        LockTest lockTest= new LockTest();
        //开10个线程
        for (int i = 0; i < 10; i++) {
            //new Thread(()->lockTest.LockTestFun()).start();
            //new Thread(()->lockTest.tryLock()).start();
            //new Thread(()->lockTest.tryLockTime()).start();

            //可重入：同一个线程可以重复获取锁；例如递归
            //读锁使用共享模式；写锁使用独占模式；读写锁互斥
            //读锁可以在没有写锁的时候被多个线程同时持有，写锁是独占的
            new Thread(()->lockTest.readLock()).start();
            new Thread(()->lockTest.writeLock()).start();
        }


    }
}

package com.zhougq.Thread.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author zhouganqing
 * @create 2020- 06- 10- 14:05
 */
public class LockTest {

    //region ReentrantLock,可重入锁

    /**
     * Lock 锁只有代码块锁,
     * */

    //可重入锁；ReentrantLock是唯一实现了Lock接口的类
    private Lock lock = new ReentrantLock();

    public void LockTestFun()
    {
        //获取锁,获取不到会一直等待,可能会死锁
        lock.lock();
        //Lock和try之间最好不好有其他代码,避免代码异常,导致lock未被释放
        try{
            System.out.println("线程"+Thread.currentThread().getName()+":拿到锁了");
            Thread.sleep(1000);

        }catch (Exception e){

        }finally {
            //释放锁,必须释放,否则死锁
            lock.unlock();
        }
    }

    public void tryLock()
    {
        //尝试获取锁;立即返回结果
        if (lock.tryLock()){
            try{
                System.out.println("线程"+Thread.currentThread().getName()+":拿到锁了");
                Thread.sleep(1000);
            }catch (Exception e){

            }finally {
                //释放锁,必须释放,否则死锁
                lock.unlock();
            }
        }else {
            //未获取到锁的情况下,丢弃或其他处理
            System.out.println("线程"+Thread.currentThread().getName()+":没有拿到锁");
        }
    }

    public void tryLockTime(){
        //尝试获取锁,未获取到锁时不立即返回结果；
        //在指定时间内会一直获取锁,若拿到锁返回true,超过指定时间未拿到锁返回false,
        try {
            //指定时间内是否获取到锁（1秒内拿到锁即可）
            if (lock.tryLock(1, TimeUnit.SECONDS))
            {
                //外面的try只针对trylock的异常；获取到锁以后需要重新try,用于释放lock
                try{
                    //获取到锁了
                    System.out.println("线程"+Thread.currentThread().getName()+":拿到锁了");
                    Thread.sleep(1000);
                }catch (Exception e){

                }finally {
                    //释放锁,必须释放,否则死锁
                    lock.unlock();
                }
            }
            else
            {
                //未获取到锁
                System.out.println("线程"+Thread.currentThread().getName()+":没有拿到锁");
            }
        } catch (InterruptedException e) {
            //该异常只针对于tryLock
            e.printStackTrace();
        }
    }

    //endregion

    //region ReentrantReadWriteLock 读写锁
    private ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private int testI = 0;

    //读锁
    public void readLock(){
        rwLock.readLock().lock();
        try {
            //获取到读锁
            System.out.println(Thread.currentThread().getName()+":获取到读锁");
            testI+=20;
            System.out.println("testI:"+testI);
            Thread.sleep(2000);
        }catch (Exception e){

        }finally {
            rwLock.readLock().unlock();
        }
    }

    //写锁
    public void writeLock(){
        rwLock.writeLock().lock();
        try {
            //获取到写锁
            System.out.println(Thread.currentThread().getName()+":获取到写锁");
            testI+=11;
            System.out.println("testI:"+testI);
            Thread.sleep(2000);
        }catch (Exception e){

        }finally {
            rwLock.writeLock().unlock();
        }
    }

    //endregion


}

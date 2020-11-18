package com.zhougq.Thread.BankSynchronized;

/**
 * @author zhouganqing
 * @create 2020- 05- 30- 16:19
 */
public class BankInfo {
    /**
     * 当使用static方法加synchronized时；锁的是class; class里的所有对象其他线程都不能访问
     * 当普通方法加synchronized时；class里的所有synchronized对象其他线程都不能访问
     *
     * */
    private static Double balance =1000.00;

    //查看余额
    public static synchronized Double getBalance() {
        return balance;
    }

    //取钱
    public static synchronized Double getBalance(Double amount) {
        balance-=amount;
        System.out.println(Thread.currentThread().getName()+":"+System.currentTimeMillis()+"取出"+amount);
        return balance;

    }

    //存钱
    public static synchronized Double setBalance(Double amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName()+":"+System.currentTimeMillis()+"存进"+amount);
        return balance;
    }
}

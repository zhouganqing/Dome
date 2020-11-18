package com.zhougq.Thread.BankSynchronized;

/**
 * @author zhouganqing
 * @create 2020- 06- 08- 13:52
 */
public class BankTest {
    public static void main(String[] args) {
        //涉及：线程等待，线程唤醒，线程同步，线程锁

        //创建银行卡对象
        BankInfo bank = new BankInfo();

        //5次
        for (int i = 0; i < 5; i++) {
            //创建取钱的线程
            new GetBankThread(bank).start();
            //创建存钱的线程
            new SetBankThread(bank).start();
        }

    }
}

package com.zhougq.Thread.BankSynchronized;

/**
 * @author zhouganqing
 * @create 2020- 05- 30- 16:35
 */
public class GetBankThread extends Thread {

    //创建银行对象
    BankInfo _bank;

    //传入银行,确保每个线程处理的是同一个银行的信息
    public GetBankThread(BankInfo bank) {
        _bank = bank;
    }

    @Override
    public void run() {
        //同步锁
        //synchronized (_bank) {
            System.out.println(Thread.currentThread().getName()+":查询余额：" + _bank.getBalance());
            //每次取100
            _bank.getBalance(100.00);
            System.out.println(Thread.currentThread().getName()+":卡里余额："+ _bank.getBalance());
            //取完钱休息一会
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        //}
    }
}

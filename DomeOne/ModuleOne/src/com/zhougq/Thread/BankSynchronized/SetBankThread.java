package com.zhougq.Thread.BankSynchronized;

/**
 * @author zhouganqing
 * @create 2020- 06- 05- 16:01
 */
public class SetBankThread extends Thread {
    BankInfo _bank;
    public SetBankThread(BankInfo bank) {
        _bank =bank;
    }

    @Override
    public void run() {
        //synchronized (_bank) {
            System.out.println(Thread.currentThread().getName()+":查询余额：" + _bank.getBalance());
            //存钱，每次存50
            _bank.setBalance(50.00);
            System.out.println(Thread.currentThread().getName()+":卡里余额："+ _bank.getBalance());
            //存完钱休息一会
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        //}
    }
}

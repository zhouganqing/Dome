package com.zhougq.Thread;

/**
 * @author zhouganqing
 * @create 2020- 05- 30- 15:50
 */
public class JoinMain {
    public static void main(String[] args) {

        Thread td = new JoinThread("Join低优先级");
        //设置优先级，默认为5；一共1-10级数字越小优先级越高
        Thread td1 = new JoinThread("Join高优先级");
        td.setPriority(8);
        for (int i = 0; i < 10; i++) {
            if (i==5)
            {
                try {
                    td.start();
                    td1.start();
                    //Join 同步操作，需等待线程执行完后当前线程才能继续执行
                    //参数 5秒，线程执行超过5秒不在等待，当前线程继续执行
                    td.join(5);
                    td1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}

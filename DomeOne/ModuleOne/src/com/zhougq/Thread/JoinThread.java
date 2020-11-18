package com.zhougq.Thread;

/**
 * @author zhouganqing
 * @create 2020- 05- 30- 15:40
 *
 */
public class JoinThread extends Thread {
    public JoinThread(String name) {
        //super代表父类
        super(name);//Thread构造函数(线程名称)
    }

    @Override
    public void run() {
        try {
            Thread.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //生成5条记录
        for (int i = 0; i < 5; i++) {
            //输出当期线程的名称
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}

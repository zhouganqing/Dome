package com.zhougq.Thread.Lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhouganqing
 * @create 2020- 06- 11- 16:56
 *
 * 使用场景：
 * 对变量的写操作不依赖于当前值 例如：i++
 * 该变量没有包含在具有其他变量的不变式中  例如：a=i+b;
 */
public class volatileTest {

    private volatile int vi=0;
    //有专门的自增自减方法,可以保证原子性
    private AtomicInteger avI= new AtomicInteger(0);

    public  void volatileMain(){
        for (int i = 0; i < 20; i++) {
            int ii = i;
            new Thread(()->ThreadFun(ii)).start();
            //System.out.println("主线程:vi="+vi);
            //System.out.println("主线程:vs="+vs);
        }
    }

    private void ThreadFun(int i) {
        for (int j = 0; j < 50; j++) {
            //if (vi>0){
            //自增函数，可以保证原子性
            avI.incrementAndGet();
            // 自减函数
            //avI.decrementAndGet();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //}
        }
        System.out.println(Thread.currentThread().getName()+":avi="+ avI.get());
    }

    private void ThreadFun() {
        for (int j = 0; j < 50; j++) {
            //if (vi>0){
            vi=vi+1;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //}
        }
        System.out.println(Thread.currentThread().getName()+":vi="+vi);
    }
}

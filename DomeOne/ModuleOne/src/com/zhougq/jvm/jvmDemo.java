package com.zhougq.jvm;

public class jvmDemo {
    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"haha");
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"bbbbb");
            },"a"+i).start();
        }
    }
}

package com.zhougq.ListMapSet;

import java.util.LinkedList;

public class HelloWord {
    public static void main(String[] args) {
        System.out.print("Hello word");

        LinkedList<Integer> linkList1 = new LinkedList<>() ;

        long startTime = System.currentTimeMillis();    //获取开始时间
        for (int i= 0;i<1000000;i++)
        {
            linkList1.addLast(i);
        }
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("addLast程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
    }
}

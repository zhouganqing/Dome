package com.zhougq.ListMapSet;

import java.util.*;

/**
 * @author zhouganqing
 * @create 2020- 05- 18- 14:25
 */
public class LinkedListDemo {

    public void LinkedListFun(){
        LinkedList<TempClass> list = new LinkedList<>();
        //添加
        list.add(new TempClass(1));
        //add==addLast
        list.addLast(new TempClass(3));
        list.addFirst(new TempClass(2));
        //push==addFirst
        list.push(new TempClass(4));

        //add==addLast
        list.offer(new TempClass(5));
        list.offerFirst(new TempClass(6));
        list.offerLast(new TempClass(7));

        //可添加重复数据
        for (int i = 0; i < 20; i++) {
             list.add(new TempClass(i));
        }

        //查询所有
        for (TempClass tempClass : list) {
            System.out.println("For:"+tempClass.getI1());
        }

        //返回并删除第一个,remove为空时会抛异常
        TempClass tA = list.remove(1);
        System.out.println("index1:"+tA.getI1());
        tA =list.removeLast();
        //默认删除第一个，==removeFirst
        tA = list.remove();
        tA = list.removeFirst();
        //pop=removeFirst
        tA = list.pop();
        //返回并删除第一个，为空时返回null不会抛异常
        tA = list.poll();
        tA = list.pollFirst();
        tA = list.pollLast();

        //获取单个,如果为空，抛异常
        list.get(1);
        list.getLast();
        list.getFirst();
        //element==getFirst
        list.element();
        //获取单个，为空时返回null，不抛异常
        list.peekLast();
        list.peek();
        //peek==peekFirst
        list.peekFirst();

        //修改索引位置的值,返回原始值
        list.set(1,new TempClass(11));




    }

    //测试不同位置(头，尾，中间)添加删除数据效率对比,ArrayList和LinkedList
    public void ArrayAndLinkedAdd()
    {
        LinkedListAdd();
        ArrayListAdd();
    }

    //LinkedList实现队列效果
    public void LinkedListToQ()
    {

        Queue<Integer> queue = new LinkedList<>() ;
        Deque<Integer> deque = new LinkedList<>() ;
        //插入用offer，使用add在有长度限制的时候会报异常，无长度限制可使用
        deque.offer(1);
        deque.offer(2);
        deque.offer(3);
        //peek  查看头部元素，element在头部无数据时会报异常
        if (deque.peek()!=null)
        {
            //因为加了peek判断，所以可以用delete
            //Integer i = deque.remove();//获取头部元素并从队列中删除
        }
        //没加peek的,只能用poll,否则抛异常
        deque.poll();//获取头部元素并从队列中删除

        queue.offer(1);
        /*long startTime1 = System.currentTimeMillis();    //获取开始时间
        while (linkList.peek()!=null)//只能用peek，其他验证为空时会抛出异常
        {
            linkList.removeLast();//获取最后一个元素，如果无任何元素抛出异常
            //linkList.pop();--获取头部元素，并删除
            linkList.pollLast();//获取最后一个元素，如果无任何元素返回null
        }

        long endTime1 = System.currentTimeMillis();    //获取结束时间
        System.out.println("addFirst程序运行时间：" + (endTime1 - startTime1) + "ms");    //输出程序运行时间
        */
    }

    private void LinkedListAdd()
    {
        LinkedList<Integer> linkList = new LinkedList<>() ;
        long startTime = System.currentTimeMillis();    //获取开始时间
        for (int i= 0;i<100;i++)
        {
            linkList.add(i/2,i);
        }
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("Linked:100条数据运行时间：" + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();    //获取开始时间
        for (int i= 0;i<1000;i++)
        {
            linkList.add(i/2,i);
        }
        endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("Linked:1000条数据运行时间：" + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();    //获取开始时间
        for (int i= 0;i<10000;i++)
        {
            linkList.add(i/2,i);
        }
        endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("Linked:10000条数据运行时间：" + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();    //获取开始时间
        for (int i= 0;i<100000;i++)
        {
            linkList.add(i/2,i);
        }
        endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("Linked:100000条数据运行时间：" + (endTime - startTime) + "ms");

        /*startTime = System.currentTimeMillis();    //获取开始时间
        for (int i= 0;i<1000000;i++)
        {
            linkList.add(i/2,i);
        }
        endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("Linked:1000000条数据运行时间：" + (endTime - startTime) + "ms");*/
    }

    private void ArrayListAdd()
    {
        ArrayList<Integer> arrayList = new ArrayList<>();
        long startTime = System.currentTimeMillis();    //获取开始时间
        for (int i= 0;i<100;i++)
        {
            arrayList.add(i/2,i);
        }
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("Array:100条数据运行时间：" + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();    //获取开始时间
        for (int i= 0;i<1000;i++)
        {
            arrayList.add(i/2,i);
        }
        endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("Array:1000条数据运行时间：" + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();    //获取开始时间
        for (int i= 0;i<10000;i++)
        {
            arrayList.add(i/2,i);
        }
        endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("Array:10000条数据运行时间：" + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();    //获取开始时间
        for (int i= 0;i<100000;i++)
        {
            arrayList.add(i/2,i);
        }
        endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("Array:100000条数据运行时间：" + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();    //获取开始时间
        for (int i= 0;i<1000000;i++)
        {
            arrayList.add(i/2,i);
        }
        endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("Array:1000000条数据运行时间：" + (endTime - startTime) + "ms");
    }
}

package com.zhougq.ListMapSet;

import java.util.*;

/**
 * @author zhouganqing
 * @create 2020- 05- 20- 13:42
 */
public class SetDemo {

    //基础类型set
    public  void SetBase()
    {
        //定义类型的Set
        HashSet<Integer> set = new HashSet<>();
        set.add(1);

        //无类型set，可以存入任何值
        HashSet set1 = new HashSet();
        set1.add(1);
        System.out.println("字符串1:" + set1.contains("1"));
        set1.add("1");
        System.out.println("带小数1:" + set1.contains(1.00));
        set1.add(1.00);
        System.out.println("数字1:" + set1.contains(1));
        set1.add(1);
        TempClass a1 = new TempClass();
        a1.setI1(1);
        set1.add(a1);
        System.out.println("set大小："+set1.size());

        //使用迭代器循环set
        Iterator iFor = set1.iterator();
        while (iFor.hasNext()) {
            Object next =  iFor.next();
            System.out.println(next);
        }
    }

    //自定义Set，需重写hashCode和equals
    public  void SetClass()
    {
        HashSet<TempClass> set = new HashSet<>();
        set.add(new TempClass(1));
        for (TempClass tempClass : set) {
            System.out.println(tempClass.getI1());
        }

        LinkedHashSet<TempClass> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(new TempClass(1));

        SortedSet<TempClass> setd = new TreeSet<>();
        setd.add(new TempClass(1));
    }

}



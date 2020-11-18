package com.zhougq.ListMapSet;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author zhouganqing
 * @create 2020- 05- 23- 10:59
 */
public class ListDemo {
    public void ListFun()
    {
        ArrayList<TempClass> list=new ArrayList<>();
        //新增,尾部追加
        list.add(new TempClass(1));
        list.add(new TempClass(6));
        list.add(new TempClass(9));
        list.add(new TempClass(3));
        //头部新增（指定索引位置插入）
        list.add(1,new TempClass(11));

        //修改指定索引位置的值,返回原始值
        TempClass T1 = list.set(1,new TempClass(6));
        System.out.println("修改时返回值："+T1.getI1());

        //判断对象是否存在,需要重写equals
        Boolean bA  = list.contains(new TempClass(1));
        System.out.println("Bool:"+bA);
        //indexOf,需要重写equals
        int a =list.indexOf(new TempClass(1));
        System.out.println("查找1索引："+a);
        a=list.indexOf(new TempClass(12));
        System.out.println("查找12索引："+a);

        //从索引处删除
        list.remove(1);
        //删除指定对象,需要重写equals
        list.remove(new TempClass(1));

        //查找，等同于indexof
        a = Collections.binarySearch(list,new TempClass(6),TempClass::compareTo);
        System.out.println("Search:"+a);

        //查询指定索引位置的值
        System.out.println("查询索引0："+list.get(0).getI1());
        //强for循环查询
        for (TempClass tempClass : list) {
            System.out.println("排序前：" +tempClass.getI1());
        }
        /*自定义的类如果需要排序,必须继承Comparable并重写compareTo方法,
          list.sort(TempClass::compareTo)//这种方式把比较函数传入
          Collections.sort(list); //使用集合处理类排序
         */
        list.sort(TempClass::compareTo);

        //listIterator只能遍历list；iterator可以遍历所有集合
        //listIterator可以向前也可以向后遍历，iterator只能向前
        /*ListIterator oit = list.listIterator();
        while (oit.hasNext()) {
            Object next =  oit.next();

        }*/

        for (TempClass tempClass : list) {
            System.out.println("排序后：" +tempClass.getI1());
        }
        Collections.sort(list);
        //方法内部匿名方法,无需实体内部重写
        /*Collections.sort(list, new Comparator<TempClass>() {
            @Override
            public int compare(TempClass o1, TempClass o2) {
                if (o1.getI1()==o2.getI1())
                {
                    return 0;
                }else if (o1.getI1()>o2.getI1())
                {
                    return 1;
                }
                return -1 ;
            }
        });*/
        for (TempClass tempClass : list) {
            System.out.println("排序后：" +tempClass.getI1());
        }
        //倒序（反向）
        Collections.reverse(list);
        for (TempClass tempClass : list) {
            System.out.println("倒序后：" +tempClass.getI1());
        }

        //随机排序,无需继承Comparable并重写compareTo方法
        Collections.shuffle(list);
        for (TempClass tempClass : list) {
            System.out.println("随机排序后：" +tempClass.getI1());
        }

    }
}

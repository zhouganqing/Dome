package com.zhougq.ListMapSet;

import java.util.*;

/**
 * @author zhouganqing
 * @create 2020- 05- 20- 17:56
 */
public class MapDemo {

    //HashMap
    public void HashMapDemo()
    {
        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.hashCode();
        hashMap.put(null,null);//map可以添加并只能添加一个null key
        //添加
        hashMap.put(22,"a");
        hashMap.put(32,"b");
        hashMap.put(23,"c");
        hashMap.put(45,"d");
        System.out.println(hashMap.size());
        System.out.println(hashMap.get(1));

        //判断key是否存在
        hashMap.containsKey(1);
        hashMap.containsValue("1");
        hashMap.isEmpty();

        //修改
        hashMap.put(1,"aa");//key相同，会自动覆盖原值
        //根据KEY查询
        hashMap.get(1);
        System.out.println("null:" + hashMap.get(null));
        //迭代查询
        Set set = hashMap.entrySet();
        Iterator iter= set.iterator();
        while (iter.hasNext()) {
            Map.Entry next =  (Map.Entry)iter.next();
            System.out.println("key:"+next.getKey()+" / value:"+next.getValue());
        }
        //强for迭代查询
        for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
            Map.Entry next =  (Map.Entry)iterator.next();
            System.out.println("key:"+next.getKey()+" / value:"+next.getValue());
        }
        //强for查询(速度最快)
        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            System.out.println("key:"+entry.getKey()+" / value:"+entry.getValue());
        }

        //删除
        hashMap.remove(1);
    }

    //LinkedHashMap
    public  void LinkedHashMapDemo()
    {
        LinkedHashMap <String,String> map= new LinkedHashMap<>();
        map.put("dd","dd44");
        map.put("Aa","Aa11");//Aa和BB的hashcode一致
        map.put("CC","CC33");
        map.put("BB","BB22");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key:"+entry.getKey()+" / value:"+entry.getValue());
        }
        //hashCode一致会在同一个地址下形成链表


        /*LinkedHashMap<Integer,String> hashMap = new LinkedHashMap<>();
        hashMap.put(null,null);//map可以添加并只能添加一个null key

        hashMap.put(22,"a");
        hashMap.put(32,"b");
        hashMap.put(23,"c");
        //put：如果key存在,修改数据,返回原始值；key不存在,新增数据,返回null；
        String a = hashMap.put(45,"d");
        System.out.println("a1:"+a);
        a = hashMap.put(45,"d222");
        System.out.println("a2:"+a);
        //replace：如果key存在,修改数据,返回原始值；key不存在,不新增任何数据,返回null；
        a = hashMap.replace(11,"a3333");
        System.out.println("a3:"+a);
        a = hashMap.replace(22,"a4444");
        System.out.println("a4:"+a);
        //compute,如果key存在,修改数据,返回原始值；key不存在,新增数据,返回新值；
        a = hashMap.compute(33,(k,v)->"v33");
        System.out.println("a5:"+a);
        a = hashMap.replace(22,"v6666");
        System.out.println("a6:"+a);

        //merge,可以给现有值运算;如果key存在,修改数据,返回新值；key不存在,新增数据,返回新值；
        a = hashMap.merge(44,"44",(oldV,newV)->oldV+newV);
        System.out.println("a7:"+a);
        a = hashMap.merge(22,"ON22",(oldV,newV)->oldV+newV);
        System.out.println("a8:"+a);


        System.out.println(hashMap.size());
        System.out.println(hashMap.get(1));





        //强for迭代查询
        for (Iterator iterator = hashMap.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry next =  (Map.Entry)iterator.next();
            System.out.println("key:"+next.getKey()+" / value:"+next.getValue());
        }*/
    }
}

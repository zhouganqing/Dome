package com.zhougq.ref;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射
 * @author zhouganqing
 * @create 2020- 05- 27- 11:35
 */
public class ReflectTester {
    private final String name = "com.zhougq.ref.CustomerMod";

    //创建对象
    public void ReflectNewInstance()
    {
        try {
            //forname必须加try catch，写包体全称
            Class clz = Class.forName(name);
            ClassLoader.getSystemClassLoader();
            //实例化类
            CustomerMod mod = (CustomerMod) clz.newInstance();
            mod.setId(new Long(1));
            mod.setAge(1);
            mod.setName("aa");

            System.out.println(mod.toString());


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //反射私有构造函数
    public void ReflectPrivateConstructor()
    {
        try {
            Class cls = Class.forName(name);
            //获取声明的构造函数；需要知道构造函数的参数类型
            Constructor contor = cls.getDeclaredConstructor(String.class,int.class);
            //设置访问权限
            contor.setAccessible(true);
            CustomerMod mod= (CustomerMod)contor.newInstance("bb",2);
            System.out.println(mod.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 反射私有方法
    public void ReflectPrivateMethod() {
        try {
            Class cls = Class.forName(name);
            CustomerMod mod= (CustomerMod)cls.newInstance();

            //获取声明的方法；需要知道方法的名称,参数个数和类型
            Method method = cls.getDeclaredMethod("declaredMethod",int.class,String.class);
            //设置访问权限
            method.setAccessible(true);
            //执行方法，传入参数,跟上面的定义类型要一致
            String str = (String) method.invoke(mod,2,"3333");
            System.out.println(str);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //反射私有属性
    public  void ReflectPrivateField(){
        try {
            Class cls = Class.forName(name);
            CustomerMod mod= (CustomerMod)cls.newInstance();
            //获取声明的属性；需要传入属性名
            Field filed = cls.getDeclaredField("id");
            //设置访问权限
            filed.setAccessible(true);
            //给属性赋值
            filed.set(mod,new Long(15));
            //获取属性值
            Long str = (Long)filed.get(mod);

            System.out.println(str);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

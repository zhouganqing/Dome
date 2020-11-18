package cn.zhou.test;

import cn.zhou.service.HelloSpring;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.management.ManagementFactory;

/**
 * @author zhouganqing
 * @create 2020- 07- 12- 18:09
 */
public class beanTest {

    public static void main(String[] args) {
        /*
        * ApplicationContext 是 BeanFactory 的子接口
        * 负责管理组件和类之间的关系
        * 面试题：ApplicationContext 和 BeanFactory 的区别?
        * */

        /*Setter 方式注入 */
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        HelloSpring helloSpring= (HelloSpring)context.getBean("helloSpring");
        helloSpring.print();
        HelloSpring helloMybatis= (HelloSpring)context.getBean("helloMybatis");
        helloMybatis.print();

        //AOP使用
        helloSpring.print("aop");

    }
}

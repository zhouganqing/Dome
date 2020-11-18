package cn.zhou.test;

import cn.zhou.service.Printer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author zhouganqing
 * @create 2020- 07- 12- 19:09
 */


public class printerTest {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        Printer printer =(Printer)context.getBean("print");
        printer.print("哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈");
    }
}

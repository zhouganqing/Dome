package cn.zhou.test;

import cn.zhou.pojo.TestEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhouganqing
 * @create 2020- 07- 17- 14:47
 */
public class testEntityTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        TestEntity entity = (TestEntity)context.getBean("testEntity");
        System.out.println(entity.toString());
    }
}

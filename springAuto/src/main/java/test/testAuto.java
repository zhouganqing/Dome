package test;

import cn.zhougq.aop.LoggerAop;
import cn.zhougq.controller.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhouganqing
 * @create 2020- 07- 17- 18:19
 */
public class testAuto {
    private static final Logger log= LoggerFactory.getLogger(testAuto.class);

    public static void main(String[] args) {
        //构造函数注入
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/springConfig.xml");
        UserController controller=(UserController)context.getBean("userController");
        controller.addUser();
    }
}

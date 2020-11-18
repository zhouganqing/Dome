package cn.zhou.test;

import cn.zhou.pojo.User;
import cn.zhou.service.impl.userServiceImpl;
import cn.zhou.service.userService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhouganqing
 * @create 2020- 07- 16- 16:22
 */
public class userTest {

    public static void main(String[] args) {
        //构造函数注入
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

        User user=(User)context.getBean("userB");
        userServiceImpl userService = (userServiceImpl)context.getBean("userService3");
        /*User user = new User();
        user.setAge(12);
        user.setPassWord("aa");
        user.setPassWord("bb");*/
        userService.addUser(user);



    }
}

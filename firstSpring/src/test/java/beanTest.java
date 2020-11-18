import cn.zhou.service.HelloSpring;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhouganqing
 * @create 2020- 07- 12- 17:58
 */
public class beanTest {
    private static ApplicationContext context;

    @BeforeClass
    public static void init(){
        context = new ClassPathXmlApplicationContext("spring/applicaionContext");
    }

    @Test
    public void beanFirst()
    {
        HelloSpring helloSpring= (HelloSpring)context.getBean("hellowSpring");
        helloSpring.print();
    }
}

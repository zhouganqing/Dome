import cn.zhougq.services.IMonitorable;
import cn.zhougq.services.INewsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhouganqing
 * @create 2020- 07- 20- 19:53
 */
public class proxyFactoryBeanTest {

    @Test
    public void proxyFactoryBeans(){

        ApplicationContext act = new ClassPathXmlApplicationContext("Spring-Mybatis.xml");
        INewsService news = (INewsService)act.getBean("newsServiceImpl");

        System.out.println("-------- 未开启监控 ------");
        news.getNewsList();//默认未开启监控

        //开启监控
        /*IMonitorable monitorable=(IMonitorable)news;
        monitorable.setActive(true);
        System.out.println("-------- 开启监控 ------");
        news.getNewsList();*/

    }
}

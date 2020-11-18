package cn.zhougq;

import cn.zhougq.pojo.News;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
class FirstRabbitmqClusterApplicationTests {

    @Autowired
    RabbitTemplate template;

    @Resource(name = "firstVmRabbitTemplate")
    RabbitTemplate firstVmTemplate;

    @Resource(name = "secondRabbitTemplate")
    RabbitTemplate secondTemplate;


    /*
    * 生产者==默认RabbitMq第一台服务器,第一个虚拟主机
    * */
    @Test
    void firstLoads() {
        News news = null;
        for (int i=0;i<10;i++)
        {
            news = new News(i,"这是第"+i+"个消息");
            //routingKey广播模式下不需要填写
            template.convertAndSend("first.fanout","",news);
        }
    }

    /*
     * 生产者==RabbitMq第一台服务器,第二个主机
     * */
    @Test
    void firstVmLoads() {
        News news = null;
        for (int i=0;i<10;i++)
        {
            news = new News(i,"这是第"+i+"个消息");
            //routingKey广播模式下不需要填写
            firstVmTemplate.convertAndSend("first.fanout","",news);
        }
    }


    /*
    * 生产者==RabbitMq第二台服务器
    * */
    @Test
    void secondLoads() {
        News news = null;
        for (int i=0;i<10;i++)
        {
            news = new News(i,"这是second第"+i+"个消息");
            //routingKey广播模式下不需要填写
            secondTemplate.convertAndSend("first.fanout","",news);
        }
    }



}

package cn.zhougq;

import cn.zhougq.pojo.News;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouganqing
 * @create 2020- 09- 23- 9:39
 */

@RunWith(SpringRunner.class)
@SpringBootTest
class MqCallBackTest {

    //给RabbitMq发送和接收消息的对象
    @Autowired
    private RabbitTemplate template;

    /*
     * 生产消息===单播模式====测试回调功能
     * */
    @Test
    void directLoads() {
        News news = new News(1,"这是第一个消息");
        //消息推送到server，但是在server里找不到交换机;触发的是 ConfirmCallback 回调函数
        //template.convertAndSend("first.direct22","news.mq",news);

        //TODO:重点 消息推送到server，找到交换机了，但是没找到队列
        //触发的是 ConfirmCallback和RetrunCallback两个回调函数
        //template.convertAndSend("first.direct","news.mq22",news);

        //消息推送到sever，交换机和队列啥都没找到;触发的是 ConfirmCallback 回调函数
        //template.convertAndSend("first.direct2","news.mq22",news);

        //消息推送成功;触发的是 ConfirmCallback 回调函数
        template.convertAndSend("first.direct","news.mq",news);
    }
}

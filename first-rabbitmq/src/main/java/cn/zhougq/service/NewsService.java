package cn.zhougq.service;

import cn.zhougq.pojo.News;
import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author zhouganqing
 * @create 2020- 09- 22- 15:43
 */

@Service
public class NewsService {

    /*
     * 注解方式监听队列进行消费,直接默认把消息转换成实体
     * 注释掉MyAckReceiver和MessageListenerConfig可以使用该方式
    * */
    /*@RabbitListener(queues = "news")
    public void receive(News news)
    {
        System.out.println(news.toString());
    }*/

    /*
    * 使用该方式,需要注释配置文件的spring.rabbitmq.listener.simple.acknowledge-mode
    * 否则会重复消费
    * */
    /*@RabbitListener(queues = "news.mq")
    public void receive(Message msg) {
        //获取消息主体内容
        System.out.println(JSON.parseObject(new String(msg.getBody()), News.class));
        //获取头部信息等出了body的所有内容
        System.out.println(msg.getMessageProperties());
    }*/


    /*
    * 注解方式实现消费消息确认
   *
    * */
    @RabbitListener(queues = "news.mq")
    public void receive(Message msg, Channel channel) throws IOException {
        long deliveryTag = msg.getMessageProperties().getDeliveryTag();
        try {
            //获取消息主体内容
            News body = JSON.parseObject(new String(msg.getBody()), News.class);
            System.out.println("==="+body.toString());
            //获取头部信息等出了body的所有内容
            System.out.println(msg.getMessageProperties());

            //int i=0;
            //int b= 5/i;
            //表示消息已被正确处理
            channel.basicAck(deliveryTag, true);
        }catch (Exception e)
        {
            channel.basicReject(deliveryTag, true);
            e.printStackTrace();
        }
    }
}

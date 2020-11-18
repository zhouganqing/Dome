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
 * @create 2020- 09- 23- 20:00
 */

@Service
public class RabbitMqService {

    //消费者==默认RabbitMq第一台服务器,第一个虚拟主机
    @RabbitListener(queues = "news.mq")
    public void firstReceive(Message msg, Channel channel) throws IOException {
        receive(msg,channel,"1、");
    }

    //消费者==RabbitMq第一台服务器,第二个主机
    @RabbitListener(queues = "news.zhougq",containerFactory = "firstVmFactory")
    public void firstVmReceive(Message msg, Channel channel) throws IOException {
        receive(msg,channel,"12、");
    }

    //消费者==RabbitMq第二台服务器
    @RabbitListener(queues = "news.zhougq",containerFactory = "secondFactory")
    public void secondReceive(Message msg, Channel channel) throws IOException {
        receive(msg,channel,"2、");
    }

    private void receive(Message msg, Channel channel,String name) throws IOException{
        long deliveryTag = msg.getMessageProperties().getDeliveryTag();
        try {
            //获取消息主体内容
            News body = JSON.parseObject(new String(msg.getBody()), News.class);
            System.out.println(name + "==="+body.toString());
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

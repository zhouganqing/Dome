package cn.zhougq.service;

import cn.zhougq.pojo.News;
import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;


/**
 * @author zhouganqing
 * @create 2020- 09- 23- 10:18
 *
 * 消费者==手动确认实现消费消息确认
 */
/*
@Component
public class MyAckReceiver implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            //因为传递消息的时候用的map传递,所以将Map从Message内取出需要做些处理
            News body = JSON.parseObject(new String(message.getBody()),News.class) ;

            if ("news".equals(message.getMessageProperties().getConsumerQueue())){
                System.out.println("消费的消息来自的队列名为："+message.getMessageProperties().getConsumerQueue());
                System.out.println("Message:" + body.toString());
                System.out.println("执行news队列中的消息的业务处理流程......");

            }

            if ("first.queue".equals(message.getMessageProperties().getConsumerQueue())){
                System.out.println("消费的消息来自的队列名为："+message.getMessageProperties().getConsumerQueue());
                System.out.println("Message:" + body.toString());
                System.out.println("执行中的消息的业务处理流程......");

            }
            //int i=0;
            //int b= 5/i;
            //表示消息已被正确处理
            channel.basicAck(deliveryTag, true);
        } catch (Exception e) {
            //为true会重新放回队列,可能导致消息积压
            //channel.basicReject(deliveryTag, true);
            //消息没有被正确处理,不重新放入队列,丢弃
            channel.basicReject(deliveryTag, false);
            e.printStackTrace();
        }
    }
}*/

package cn.zhougq;

import cn.zhougq.pojo.News;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
class FirstRabbitmqApplicationTests {

    //给RabbitMq发送和接收消息的对象
    @Autowired
    private RabbitTemplate template;

    //系统管理功能组件 创建和删除Exchange,Queue,Binding
    @Autowired
    private AmqpAdmin amqpAdmin;

    //创建Exchange
    @Test
    void createExchange(){
        //创建单播模式
        amqpAdmin.declareExchange(new DirectExchange("second.direct"));
        //创建广播模式
        amqpAdmin.declareExchange(new FanoutExchange("second.fanout"));
        //创建匹配模式
        amqpAdmin.declareExchange(new TopicExchange("second.topic"));

    }

    //创建队列
    @Test
    void createQueue(){
        // durable:是否持久化,默认是true,持久化队列：会被存储在磁盘上，当消息代理重启时仍然存在，暂存队列：当前连接有效
        // exclusive:默认false，只能被当前创建的连接使用，而且当连接关闭后队列即被删除。此参考优先级高于durable
        // autoDelete:是否自动删除，当没有生产者或者消费者使用此队列，该队列会自动删除。
        amqpAdmin.declareQueue(new Queue("second.queue"));
    }

    //创建绑定信息
    @Test
    void createBinding(){
        /*
        * String destination==目的地,一般写队列名
        * Binding.DestinationType destinationType,
        * String exchange==绑定的路由名
        * String routingKey,==路由规则
        * @Nullable Map<String, Object> arguments 参数
        *
        * */
        //direct 绑定
        amqpAdmin.declareBinding(new Binding("second.queue", Binding.DestinationType.QUEUE,"second.direct","haha.queue",null));
        //fanout 绑定
        amqpAdmin.declareBinding(new Binding("second.queue", Binding.DestinationType.QUEUE,"second.fanout","",null));
        //topic 绑定
        amqpAdmin.declareBinding(new Binding("second.queue", Binding.DestinationType.QUEUE,"second.topic","#.queue",null));
    }

    /*
    * 生产消息===单播模式
    * */
    @Test
    void directLoads() {
        //自定义消息体和消息内容；Message需要自己构造一个
        //template.send(exchange,routingkey,message)

        Map<String,Object> map = new HashMap<>();
        map.put("msg","这是第一个消息");
        map.put("data", Arrays.asList("hello word",123,true));
        //object默认当成消息体,只需要传入发送的内容,自动序列化发给RabbitMq
        template.convertAndSend("first.direct","news.mq",map);
    }

    /*
    * 生产消息===广播模式
    * */
    @Test
    void fanoutLoads() {
        News news = null;//new News(1,"这是第一个消息");
        for (int i=0;i<10;i++)
        {
            news = new News(i,"这是第"+i+"个消息");
            //routingKey广播模式下不需要填写
            template.convertAndSend("first.fanout","",news);
        }


    }

    /*
     * 生产消息===匹配模式(Topic)
     * */
    @Test
    void topicLoads() {
        News news = new News(1,"这是第一个消息");
        //routingKey匹配就进队列
        template.convertAndSend("first.topic","news.aa",news);
    }


    /*
    * 消费者消息
    * */
    @Test
    void receiveLoads() {
        //队列名称
        Object object = template.receiveAndConvert("news.mq");
        System.out.println(object.getClass());
        System.out.println(object);
    }
}

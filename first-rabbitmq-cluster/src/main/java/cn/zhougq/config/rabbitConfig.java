package cn.zhougq.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author zhouganqing
 * @create 2020- 09- 23- 18:05
 */

@Configuration
public class rabbitConfig {

    /*
    * 定义集群连接,第一台服务器
    * */
    @Bean(name = "firstConnectionFactory")
    @Primary
    public ConnectionFactory firstConnectionFactory(
            @Value("${spring.rabbitmq.first.host}") String host,
            @Value("${spring.rabbitmq.first.port}") int port,
            @Value("${spring.rabbitmq.first.username}") String username,
            @Value("${spring.rabbitmq.first.password}") String password,
            @Value("${spring.rabbitmq.first.virtual-host}") String vmhost
    ) {
        return connectionFactory(host, port, username, password,vmhost);
    }
    /*同一台服务器,不同的virtual-host*/
    @Bean(name = "firstVmConnectionFactory")
    public ConnectionFactory firstVmConnectionFactory(
            @Value("${spring.rabbitmq.first.host}") String host,
            @Value("${spring.rabbitmq.first.port}") int port,
            @Value("${spring.rabbitmq.first.username}") String username,
            @Value("${spring.rabbitmq.first.password}") String password,
            @Value("${spring.rabbitmq.second.virtual-host}") String vmhost
    ) {
        return connectionFactory(host, port, username, password,vmhost);
    }
    //第二台服务器
    @Bean(name = "secondConnectionFactory")
    public ConnectionFactory secondConnectionFactory(
            @Value("${spring.rabbitmq.second.host}") String host,
            @Value("${spring.rabbitmq.second.port}") int port,
            @Value("${spring.rabbitmq.second.username}") String username,
            @Value("${spring.rabbitmq.second.password}") String password,
            @Value("${spring.rabbitmq.second.virtual-host}") String vmhost
    ) {
        return connectionFactory(host, port, username, password,vmhost);
    }

    private CachingConnectionFactory connectionFactory(String host, int port, String username, String password,String virtual_host){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setPort(port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(virtual_host);
        return connectionFactory;
    }


    /*
    * 定义生产者操作类
    * */
    @Bean(name = "firstRabbitTemplate")
    @Primary
    public RabbitTemplate firstRabbitTemplate(
            @Qualifier("firstConnectionFactory") ConnectionFactory connectionFactory
    ) {
        return getRabbitTemplate(connectionFactory);
    }
    @Bean(name = "firstVmRabbitTemplate")
    public RabbitTemplate firstVmRabbitTemplate(
            @Qualifier("firstVmConnectionFactory") ConnectionFactory connectionFactory
    ) {
        return getRabbitTemplate(connectionFactory);
    }
    @Bean(name = "secondRabbitTemplate")
    public RabbitTemplate secondRabbitTemplate(
            @Qualifier("secondConnectionFactory") ConnectionFactory connectionFactory
    ) {
        return getRabbitTemplate(connectionFactory);
    }

    private RabbitTemplate getRabbitTemplate(ConnectionFactory connectionFactory){

        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        //rabbitmq序列化方式改为json
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.setConnectionFactory(connectionFactory);
        //设置开启Mandatory,才能触发回调函数,无论消息推送结果怎么样都强制调用回调函数
        rabbitTemplate.setMandatory(true);

        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                System.out.println("ConfirmCallback:     "+"相关数据："+correlationData);
                System.out.println("ConfirmCallback:     "+"确认情况："+ack);
                System.out.println("ConfirmCallback:     "+"原因："+cause);
            }
        });

        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                System.out.println("ReturnCallback:     "+"消息："+message);
                System.out.println("ReturnCallback:     "+"回应码："+replyCode);
                System.out.println("ReturnCallback:     "+"回应信息："+replyText);
                System.out.println("ReturnCallback:     "+"交换机："+exchange);
                System.out.println("ReturnCallback:     "+"路由键："+routingKey);
            }
        });

        return rabbitTemplate;
    }

    /*
    * 定义消费者监听类
    * */
    @Bean(name = "firstFactory")
    @Primary
    public SimpleRabbitListenerContainerFactory firstFactory(
            SimpleRabbitListenerContainerFactoryConfigurer configurer,
            @Qualifier("firstConnectionFactory") ConnectionFactory connectionFactory
    ) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        return factory;
    }
    @Bean(name = "firstVmFactory")
    public SimpleRabbitListenerContainerFactory firstVmFactory(
            SimpleRabbitListenerContainerFactoryConfigurer configurer,
            @Qualifier("firstVmConnectionFactory") ConnectionFactory connectionFactory
    ) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        return factory;
    }

    @Bean(name = "secondFactory")
    public SimpleRabbitListenerContainerFactory secondFactory(
            SimpleRabbitListenerContainerFactoryConfigurer configurer,
            @Qualifier("secondConnectionFactory") ConnectionFactory connectionFactory
    ) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        return factory;
    }
}

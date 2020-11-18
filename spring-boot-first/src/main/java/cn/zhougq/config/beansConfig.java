package cn.zhougq.config;

import cn.zhougq.service.testBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhouganqing
 * @create 2020- 08- 28- 10:03
 *
 * springboot 配置类,替代之前spring的配置文件
 * xml <bean id="" class=""/>    ==== @Bean
 */
@Configuration
public class beansConfig {

    //将方法的返回值添加到容器中,容器中这个组件的默认ID,就是方法名
    @Bean
    public testBean testB()
    {
        System.out.println("hahaa");
        return new testBean();
    }

}

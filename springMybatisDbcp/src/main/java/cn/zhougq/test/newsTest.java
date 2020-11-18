package cn.zhougq.test;

import cn.zhougq.dao.NewsMapper;
import cn.zhougq.entitys.NewsMod;
import cn.zhougq.services.INewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouganqing
 * @create 2020- 07- 19- 11:06
 */
public class newsTest {
    static Logger log = LoggerFactory.getLogger(newsTest.class);
    public static void main(String[] args) {

        ApplicationContext act = new ClassPathXmlApplicationContext("Spring-Mybatis.xml");
        INewsService news = (INewsService)act.getBean("newsServiceImpl");
        //打印所有bean名称
        /*for (String name : act.getBeanDefinitionNames()) {
            System.out.println(name);
        }*/
        NewsMod mod1 = new NewsMod();
        mod1.setTitle("Mybatis 新增1");
        mod1.setContent("Mybatis 新增明细1");

        List<NewsMod> list = new ArrayList<>();
        list.add(mod1);
        list.add(mod1);
        news.addNews(list);

        //System.out.println("Mybatis 新增ID:"+mod1.getId());


        List<NewsMod> list1 = news.getNewsList();
        for (NewsMod mod : list1) {
            System.out.println(mod.getId()+":"+mod.getTitle());
        }
    }
}

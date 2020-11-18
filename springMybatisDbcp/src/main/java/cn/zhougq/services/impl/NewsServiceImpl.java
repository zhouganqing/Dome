package cn.zhougq.services.impl;

import cn.zhougq.dao.NewsMapper;
import cn.zhougq.entitys.NewsMod;
import cn.zhougq.services.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhouganqing
 * @create 2020- 07- 19- 14:50
 */

@Service
/*整个类都支持事务*/
/*@Transactional*/
public class NewsServiceImpl implements INewsService {

    @Autowired
    NewsMapper news;

    public NewsMapper getNews() {
        return news;
    }

    public void setNews(NewsMapper news) {
        this.news = news;
    }

    @Override
    public List<NewsMod> getNewsList() {
        System.out.println("执行sql方法");
        //throw new RuntimeException("测试程序运行时异常情况下的增强操作");
        return news.getNewsList();
    }

    @Override
    public Integer addNews(NewsMod mod) {

        return  news.insertNews(mod);
    }

    @Override
    /*单独某个方法支持事务*/
    @Transactional
    public void addNews(List<NewsMod> list) {
        for (NewsMod mod : list) {
            addNews(mod);
            throw new RuntimeException();
        }
    }
}

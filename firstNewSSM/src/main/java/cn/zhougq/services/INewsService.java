package cn.zhougq.services;

import cn.zhougq.entitys.NewsMod;

import java.util.List;

/**
 * @author zhouganqing
 * @create 2020- 07- 19- 14:49
 */
public interface INewsService {
    List<NewsMod> getNewsList();

    Integer addNews(NewsMod mod);

    void addNews(List<NewsMod> list);
}

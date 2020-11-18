package cn.zhougq.dao;

import cn.zhougq.entitys.NewsMod;

import java.util.List;

/**
 * @author zhouganqing
 * @create 2020- 07- 19- 11:10
 */
public interface NewsMapper {
    List<NewsMod> getNewsList();

    Integer insertNews(NewsMod mod);
}

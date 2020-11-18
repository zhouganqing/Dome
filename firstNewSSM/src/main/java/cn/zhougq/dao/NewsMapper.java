package cn.zhougq.dao;

import cn.zhougq.entitys.NewsMod;

import java.util.List;

/**
 * @author zhouganqing
 * @create 2020- 07- 30- 14:42
 */
public interface NewsMapper {
    List<NewsMod> getNewsList();

    Integer insertNews(NewsMod mod);
}

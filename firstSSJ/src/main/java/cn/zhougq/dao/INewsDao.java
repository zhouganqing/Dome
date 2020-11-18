package cn.zhougq.dao;

import cn.zhougq.entytis.NewsMod;

import java.util.List;

/**
 * @author zhouganqing
 * @create 2020- 07- 25- 15:22
 */
public interface INewsDao {
    //新增
    int addNews(String title,String content);
    //修改
    int updateNews(String title,String content,int id);
    //删除
    int deleteNews(int id);
    //获取实体
    NewsMod getNewMod(int id);
    //获取数据集
    List<NewsMod> getNews();
    //根据标题搜索
    List<NewsMod> getNewsByTitle(String title);
}

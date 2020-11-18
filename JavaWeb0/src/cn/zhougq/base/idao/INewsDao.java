package cn.zhougq.base.idao;

import cn.zhougq.model.NewsMod;

import java.util.List;

/**
 * @author zhouganqing
 * @create 2020- 06- 04- 9:25
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

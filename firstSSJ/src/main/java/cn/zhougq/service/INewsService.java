package cn.zhougq.service;


import cn.zhougq.entytis.NewsMod;

import java.util.List;

/**
 * @author zhouganqing
 * @create 2020- 06- 14- 17:02
 */
public interface INewsService {
    //获取list
    List<NewsMod> getList();

    int addNews(NewsMod mod);

    NewsMod getNewMod(int id);
}

package cn.zhougq.iservice;

import cn.zhougq.model.NewsMod;

import java.util.List;

/**
 * @author zhouganqing
 * @create 2020- 06- 14- 17:02
 */
public interface INewsService {
    //获取list
    public List<NewsMod> getList();
}

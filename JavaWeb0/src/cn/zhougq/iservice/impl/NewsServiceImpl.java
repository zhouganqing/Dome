package cn.zhougq.iservice.impl;

import cn.zhougq.base.idao.INewsDao;
import cn.zhougq.base.impl.NewDaoImpl;
import cn.zhougq.iservice.INewsService;
import cn.zhougq.model.NewsMod;

import java.util.List;

/**
 * @author zhouganqing
 * @create 2020- 06- 14- 17:03
 */
public class NewsServiceImpl implements INewsService {

    @Override
    public List<NewsMod> getList() {
        INewsDao news = new NewDaoImpl();
        return news.getNews();
    }
}

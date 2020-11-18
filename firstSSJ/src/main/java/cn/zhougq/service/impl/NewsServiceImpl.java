package cn.zhougq.service.impl;

import cn.zhougq.dao.INewsDao;
import cn.zhougq.entytis.NewsMod;
import cn.zhougq.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhouganqing
 * @create 2020- 06- 14- 17:03
 */

@Service
public class NewsServiceImpl implements INewsService {

    @Autowired
    /*@Qualifier("newsDao")*/
    INewsDao news ;

    @Override
    public List<NewsMod> getList() {
        return news.getNews();
    }

    @Override
    public int addNews(NewsMod mod) {
        return news.addNews(mod.getTitle(),mod.getContent());
    }

    @Override
    public NewsMod getNewMod(int id) {
        return news.getNewMod(id);
    }
}

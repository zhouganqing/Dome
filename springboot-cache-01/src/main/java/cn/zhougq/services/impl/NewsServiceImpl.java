package cn.zhougq.services.impl;

import cn.zhougq.entitys.NewsInfo;
import cn.zhougq.mapper.NewsMapper;
import cn.zhougq.services.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhouganqing
 * @create 2020- 09- 05- 12:11
 */

@Service
public class NewsServiceImpl implements INewsService {

    @Autowired
    NewsMapper newsMapper;

    @Override
    public NewsInfo getNewsById(Integer id) {
        return newsMapper.getNewsInfoById(id);
    }

    @Override
    public NewsInfo updateNews(NewsInfo newsInfo) {
        newsMapper.updateNews(newsInfo);
        return newsInfo;
    }

    @Override
    public void deleteNewsById(Integer id) {
        //可以不执行实际删除的资方，只清除缓存数据
        System.out.println("====已清除缓存=======");
        //newsMapper.deleteNewsById(id);

    }

    @Override
    public NewsInfo getNews(Integer id) {
        return null;
    }
}

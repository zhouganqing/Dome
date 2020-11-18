package cn.zhougq.controller;

import cn.zhougq.entitys.NewsInfo;
import cn.zhougq.services.INewsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouganqing
 * @create 2020- 09- 05- 12:14
 */

@RestController
public class NewsController {

    @Autowired
    INewsService newsService;

    @GetMapping("news/{id}")
    public NewsInfo getNewsById(@PathVariable("id")Integer id)
    {
        return newsService.getNewsById(id);
    }

    @GetMapping("news")
    public NewsInfo updateNewsById(NewsInfo info)
    {
        return newsService.updateNews(info);
    }

    @GetMapping("news/del")
    public String deleteNewsById(@Param("id") Integer id)
    {
        newsService.deleteNewsById(id);
        return "true";
    }

}

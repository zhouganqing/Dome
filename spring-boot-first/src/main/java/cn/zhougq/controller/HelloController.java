package cn.zhougq.controller;

import cn.zhougq.entity.NewsInfo;
import cn.zhougq.entity.NewsJpa;
import cn.zhougq.entity.NewsMod;
import cn.zhougq.mapper.INewsJpa;
import cn.zhougq.mapper.NewsMapper;
import cn.zhougq.mapper.NewsModMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zhouganqing
 * @create 2020- 08- 27- 9:54
 */

//@ResponseBody这个类的所有方法返回的数据直接写给浏览器,如果是对象转为json数据
//RestController==@ResponseBody + @Controller
@RestController
public class HelloController {


    @RequestMapping("hello")
    public List<String> hello()
    {
        List<String> list = new ArrayList<>();
        list.add("Hello Spring Boot");
        return list;
    }

    @Autowired
    private JdbcTemplate template;
    @GetMapping("getNews")
    public List<Map<String,Object>> getJdbcNews(){
        List<Map<String,Object>> list = template.queryForList("select * from news ");
        return list;
    }

    @Autowired
    private NewsMapper news;
    @GetMapping("news/{id}")
    public NewsInfo getNewsById(@PathVariable("id") Integer id ){
        NewsInfo info = news.getNewsInfoById(id);
        return info;
    }

    //http://localhost:8083/springboot/news/add?newName=aaaa2&newinfo=bbbb2
    //get请求,这种参数方式也可以插入数据,参数名必须和属性名一致,区分大小写
    @GetMapping("news/add")
    public NewsInfo insertNews(NewsInfo info ){
        news.insertNews(info);
        return info;
    }

    @Autowired
    private NewsModMapper newsMod;
    @GetMapping("newsMod/{id}")
    public NewsMod getNewsModeById(@PathVariable("id") Integer id ){
        NewsMod info = newsMod.getNewsModById(id);
        return info;
    }

    @Autowired
    INewsJpa iNewsJpa;
    @GetMapping("newsJpa/{id}")
    public NewsJpa getNewsJpaById(@PathVariable("id") Integer id ){
        NewsJpa info = iNewsJpa.findById(id).orElse(null);
        return info;
    }
    @GetMapping("newsJpa/add")
    public NewsJpa getNewsJpaById(NewsJpa newsInfo){
        NewsJpa info = iNewsJpa.save(newsInfo);
        return info;
    }

}

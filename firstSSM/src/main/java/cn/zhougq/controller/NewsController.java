package cn.zhougq.controller;

import cn.zhougq.services.INewsService;
import cn.zhougq.until.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

/**
 * @author zhouganqing
 * @create 2020- 07- 25- 15:43
 */

@Controller
@RequestMapping("news")
public class NewsController {

    Logger log =  LoggerFactory.getLogger(NewsController.class);
    @Autowired
    INewsService newsService;

    @RequestMapping(value ="/getList")
    public String getList(Model mod, HttpSession session) {
        if (session.getAttribute(Constants.USER_SESSION)==null)
        {
            return  "redirect:/user/login";
        }
        mod.addAttribute("list",newsService.getNewsList());
        return "news";
    }

}

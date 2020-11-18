package cn.zhougq.controller;

import cn.zhougq.entitys.NewsMod;
import cn.zhougq.services.INewsService;
import cn.zhougq.untils.Constants;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
        log.info("getList");
        if (session.getAttribute(Constants.USER_SESSION)==null)
        {
            return  "redirect:/user/login";
        }
        mod.addAttribute("list",newsService.getNewsList());
        return "news";
    }

    @RequestMapping(value ="/getJson/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Object getJson(@PathVariable String id) {
        log.info("getJson:"+id);

        //JSON 转 对象
        /*String jsons ="";
        NewsMod mod = JSONObject.parseObject(jsons,NewsMod.class);
        //先转成功JSON对象,在转实体
        JSON j = JSONObject.parseObject("");
        NewsMod mod = JSONObject.toJavaObject(j,NewsMod.class);*/

        return JSONObject.toJSONString(newsService.getNewsList());
    }

}

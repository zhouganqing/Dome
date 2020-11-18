package cn.zhougq.controller;

import cn.zhougq.entytis.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author zhouganqing
 * @create 2020- 07- 25- 13:07
 */

@Controller
@RequestMapping("index")
public class IndexController {
    private Logger log= LoggerFactory.getLogger(IndexController.class);


    /*
    value = "username",required = false
    给参数取别名,是否必填,默认必填
    */
    @RequestMapping(value ="/info",method = RequestMethod.GET)
    public ModelAndView index(@RequestParam(value = "username",required = false) String username) {
        log.info(username);
        ModelAndView mv = new ModelAndView();
        mv.addObject("username", username);
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping(value ="/info1")
    public String index(@RequestParam String username, Model model) {
        log.info(username);
        model.addAttribute("username", username);
        /*前台通过类型直接获取值*/
        model.addAttribute(username);

        User user = new User();
        user.setUsername(username);
        model.addAttribute("userMod",user);
        return "index";
    }

    @RequestMapping(value ="/info2")
    public String index(@RequestParam String username, Map<String,Object> model) {
        log.info(username);
        model.put("username", username);

        User user = new User();
        user.setUsername(username);
        model.put("userMod",user);
        return "index";
    }

    @RequestMapping(value ="/index")
    public String index() {
        log.info("index");
        //直接返回视图
        return "index";
    }
}

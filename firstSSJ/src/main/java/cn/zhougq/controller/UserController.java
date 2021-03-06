package cn.zhougq.controller;

import cn.zhougq.util.BaseType;
import cn.zhougq.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author zhouganqing
 * @create 2020- 07- 25- 17:16
 */
@Controller
@RequestMapping("user")
public class UserController {
    Logger log = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login()
    {
        //Integer.parseInt("a");
        return "login";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST,
    params = {"username","password"})
    public String login(String username, String password,
                        HttpSession session, HttpServletRequest request) {
        log.info(username,password);
        if (BaseType.IsEmpty(username)||BaseType.IsEmpty(password))
        {
            request.setAttribute("error","用户名或密码错误");
            return "login";
        }

        //放入session
        session.setAttribute(Constants.USER_SESSION,username);
        //执行到UserController的mian方法
        return "redirect:/news/getList";
        //return "news";
    }
}

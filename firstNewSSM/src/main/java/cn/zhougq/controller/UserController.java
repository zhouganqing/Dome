package cn.zhougq.controller;

import cn.zhougq.untils.BaseType;
import cn.zhougq.untils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @ExceptionHandler(value = {RuntimeException.class})
    public String handlException(RuntimeException e,HttpServletRequest req)
    {
        req.setAttribute("e",e);
        return "error";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST,
    params = {"username","password"})
    public String login(String username, String password,
                        HttpSession session, HttpServletRequest request) {
        log.info(username,password);
        int i=0;
        int a =5/i;
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

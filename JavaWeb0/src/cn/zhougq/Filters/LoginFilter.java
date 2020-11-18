package cn.zhougq.Filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhouganqing
 * @create 2020- 07- 05- 14:51
 */
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("LoginFilter执行开始.......");
        //向下转型
        HttpServletRequest req=(HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse)servletResponse;

        String userName = (String) req.getSession().getAttribute("userName");
        if (userName==null||userName=="")
        {
            /*只能服务器端转发，不能客户端重定向*/
            req.getRequestDispatcher("/error.jsp").forward(servletRequest, servletResponse);
            //res.sendRedirect(req.getContextPath()+"/error.jsp");
        }
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("LoginFilter执行结束.......");
    }
}

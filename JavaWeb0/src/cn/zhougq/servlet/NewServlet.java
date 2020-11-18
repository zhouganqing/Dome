package cn.zhougq.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author zhouganqing
 * @create 2020- 07- 05- 9:46
 */
public class NewServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("业务处理");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("销毁");
    }
}

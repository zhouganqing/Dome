package cn.zhougq.Filters;


import javax.servlet.*;
import java.io.IOException;

/**
 * @author zhouganqing
 * @create 2020- 07- 05- 13:52
 */
public class CharSetFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("CharSetFilter执行开始.......");

        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");

        //放行
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("charSetFilter执行结束.......");
    }
}

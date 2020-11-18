package cn.zhougq.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhouganqing
 * @create 2020- 07- 05- 11:22
 */
public class loginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String basePath = request.getScheme()+"://"+request.getServerName()+":"
                +request.getServerPort()+request.getContextPath()+"/";

        //解决乱码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //获取页面的参数
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        //处理逻辑
        if (userName.equals("zhougq") && password.equals("123456"))
        {
            //登录成功 request 添加参数，转发时带过去
            request.setAttribute("msg","登录成功");
            //保存登录信息
            request.getSession().setAttribute("userName",userName);

            //转发路径 ：/代表当前项目路径http://127.0.0.1:8803/javaWeb0/
            request.getRequestDispatcher("/loginSubmit.jsp").forward(request,response);
        }
        else{
            //登录失败
            /* 重定向页面 url:/左斜杠代表   http://ip:端口/        */
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }
    }
}

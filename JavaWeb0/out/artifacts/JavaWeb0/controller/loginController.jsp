<%--
  User: zhouganqing
  Date: 2020/6/5
  Time: 13:59
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
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
        session.setAttribute("userName",userName);

        //转发路径 ：/代表当前项目路径http://127.0.0.1:8803/javaWeb0/
        request.getRequestDispatcher("/loginSubmit.jsp").forward(request,response);
    }
    else{
        //登录失败
        /* 重定向页面 url:/左斜杠代表   http://ip:端口/        */
        response.sendRedirect(request.getContextPath()+"/error.jsp");
    }
%>

<%--
  Created by IntelliJ IDEA.
  User: 539803
  Date: 2020/5/27
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //获取站点（应用）
    String path=request.getContextPath();
    //分段获取站点全路径(当前站点协议,服务器名称,端口号,站点名)
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>
<%
    //表单方式提交，中文乱码处理
    //表单提交get方式，中文乱码处理方式二：修改server.xml tomcat安装目录下
    request.setCharacterEncoding("utf-8");
    String userName = request.getParameter("username");
    String password = request.getParameter("password");
    //设置session过期时间（秒）
    //session.setMaxInactiveInterval(5);
    //session.setAttribute("userName",userName);

%>
<%= request.getAttribute("msg")%>
用户名：<%= userName%><br/>
密码：<%= password%><br/>
<button type="button" onclick="javascript:location.href='<%=request.getContextPath()%>/MyInfo.jsp'" >我的信息</button>
<button type="button" onclick="javascript:location.href='<%=request.getContextPath()%>/loginOut.jsp'" >退出</button>
</body>
</html>

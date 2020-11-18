<%--
  Created by IntelliJ IDEA.
  User: 539803
  Date: 2020/5/27
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>退出</title>
</head>
<body>
<%
    //清除session
    session.removeAttribute("userName");
    response.sendRedirect(request.getContextPath()+"/login.jsp");
%>
</body>
</html>

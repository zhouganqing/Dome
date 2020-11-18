<%--
  Created by IntelliJ IDEA.
  User: 539803
  Date: 2020/5/27
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>基础信息</title>
</head>
<body>
<%
    String userName = (String)session.getAttribute("userName");
    if (userName==null || userName.isEmpty())//为空
    {
        response.sendRedirect("/JavaWeb0/login.jsp");
    }
%>
<table>
    <tr>
        <td>
            用户名：
        </td>
    </tr>
</table>
</body>
</html>

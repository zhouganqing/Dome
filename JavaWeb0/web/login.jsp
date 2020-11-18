<%--
  Created by IntelliJ IDEA.
  User: 539803
  Date: 2020/5/27
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link style="/css/common.css">
</head>
<body>
<%//定义form表单，submit时自动提交到action指定的路径；method：提交方式%>
<form name="loginForm" id="loginForm" action="<%= request.getContextPath()%>/login" method="post">
    <table class="tb" border="0" cellspacing="5" cellpadding="0" align="center">
        <tr><td align="center" colspan="2" style="text-align:center;" class="text_tabledetail2">用户登录</td></tr>
        <tr>
            <td class="text_tabledetail2">用户名</td>
            <td><input type="text" name="username" value=""/></td>
        </tr>
        <tr>
            <td class="text_tabledetail2">密码</td>
            <td><input type="password" name="password" value=""/></td>
        </tr>
        <tr>
            <td style="text-align:center;" colspan="2">
                <button type="submit" class="page-btn" name="save">登录</button>
                <input type="reset" value="重置">
            </td>
        </tr>
    </table>
</form>
</body>
</html>

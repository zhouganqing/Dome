<%--
  User: zhouganqing
  Date: 2020/6/21
  Time: 10:00
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>框架</title>
</head>
<body>
<table width="100%">
    <tr>
        <td colspan="2" style="text-align: center"
            <jsp:include page="headForm.jsp"/>
        </td>
    </tr>
    <tr>
        <td><jsp:include page="leftForm.jsp"/></td>
        <td><jsp:include page="rightForm.jsp"/></td>
    </tr>
    <tr>
        <td colspan="2" style="text-align: center">
            <jsp:include page="footForm.jsp"/>
        </td>
    </tr>
</table>
</body>
</html>

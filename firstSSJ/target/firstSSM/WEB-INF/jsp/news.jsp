<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  User: zhouganqing
  Date: 2020/7/25
  Time: 15:46
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>news</title>
</head>
<body>
<c:forEach var="news" items="${list}" varStatus="status">
    <c:out value="${news.id}"/>
    <c:out value="${news.title}"/>
    <p/>
    <c:out value="${news.content}"/>
</c:forEach>
123
<h1>欢迎登录：${userSession}</h1>
</body>
</html>

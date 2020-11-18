<%@ page import="cn.zhougq.model.NewsMod" %>
<%@ page import="java.util.List" %><%--
  User: zhouganqing
  Date: 2020/6/21
  Time: 10:06
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="news" class="cn.zhougq.iservice.impl.NewsServiceImpl" scope="page"></jsp:useBean>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script>
    function goUrl() {
        location.href="addNews.jsp";
    }
</script>
<input type="button" onclick="goUrl()" value="新增" />
<table>
    <tr>
        <td width="50px">编号</td>
        <td style="width: 200px">标题</td>
        <td style="width: 150px">内容</td>
        <td style="width: 100px">操作</td>
    </tr>
    <%
        List<NewsMod> list = news.getList();
        for(NewsMod mod : list){%>
    <tr>
        <td width="50px"><%= mod.getId()%></td>
        <td style="width: 200px"><%= mod.getTitle()%></td>
        <td style="width: 150px"><%= mod.getContent()%></td>
        <td style="width: 100px"><a>删除</a></td>
    </tr>
    <%}%>
</table>
</body>
</html>

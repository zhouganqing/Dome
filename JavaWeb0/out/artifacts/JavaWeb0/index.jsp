<%@ page import="cn.zhougq.iservice.INewsService" %>
<%@ page import="cn.zhougq.iservice.impl.NewsServiceImpl" %>
<%@ page import="cn.zhougq.model.NewsMod" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 539803
  Date: 2020/5/17
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
  //获取站点（应用）
  String path=request.getContextPath();
  //分段获取站点全路径(当前站点协议,服务器名称,端口号,站点名)
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%--等同于 NewsServiceImpl news = new NewsServiceImpl();--%>
<jsp:useBean id="news" class="cn.zhougq.iservice.impl.NewsServiceImpl" scope="page"></jsp:useBean>
<html>
  <head>
    <base href="<%= basePath%>">
    <title>Hello</title>
    <link style="/css/common.css">
  </head>
  <body>
  <div>Hello word  哈哈哈哈哈哈</div>
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
      <td width="50px"><%=mod.getId()%></td>
      <td style="width: 200px"><%= mod.getTitle()%></td>
      <td style="width: 150px"><%= mod.getContent()%></td>
      <td style="width: 100px"><a>删除</a></td>
    </tr>
    <%}%>
  </table>
  </body>
</html>

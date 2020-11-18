<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="cn.zhougq.services.INewsService" %>
<%@ page import="cn.zhougq.entitys.NewsMod" %>
<%@ page import="java.util.List" %>
<html>
<body>
<h2>Hello World!123456</h2>
</body>
<%
    ApplicationContext act = new ClassPathXmlApplicationContext("Spring-Mybatis.xml");
    INewsService news = (INewsService)act.getBean("newsServiceImpl");

    List<NewsMod> list1 = news.getNewsList();
    for (NewsMod mod : list1) {
        %>
<p>
<%
    mod.getId()+":"+mod.getTitle();
%>
</p>

    }
%>
</html>

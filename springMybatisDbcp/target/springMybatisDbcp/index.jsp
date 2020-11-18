<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="cn.zhougq.services.INewsService" %>
<html>
<body>
<h2>Hello World!123456</h2>
</body>
<%
    ApplicationContext act = new ClassPathXmlApplicationContext("Spring-Mybatis.xml");
    INewsService news = (INewsService)act.getBean("newsServiceImpl");

    System.out.println("-------- 未开启监控 ------");
    news.getNewsList();//默认未开启监控
%>
</html>

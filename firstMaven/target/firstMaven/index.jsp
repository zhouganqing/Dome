<%@ page import="org.slf4j.Logger" %>
<%@ page import="org.slf4j.LoggerFactory" %>
<html>
<body>
<h2>Hello World!</h2>
<h2>Hello World!</h2>
<%
    final Logger log = LoggerFactory.getLogger("MainLogger");
    log.info("info");
    log.debug("debug");
    log.warn("warn");
    log.error("error");
%>
</body>
</html>

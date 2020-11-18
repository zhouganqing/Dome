<%--
  User: zhouganqing
  Date: 2020/7/26
  Time: 11:26
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fm" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>添加新闻</title>
    <link href="${pageContext.request.contextPath}/statics/css/common.css">
</head>
<body>

<%--没设置提交路径：因为默认get访问时使用的是哪个名字,提交时就用同名的post方法--%>
<fm:form method="post" modelAttribute="news" enctype="multipart/form-data">
    <table class="tb" border="0" cellspacing="5" cellpadding="0" align="center">
        <tr><td align="center" colspan="2" style="text-align:center;" class="text_tabledetail2">添加新闻</td></tr>
        <tr>
            <td class="text_tabledetail2">标题</td>
            <td><fm:input path="title"/></td>
        </tr>
        <tr>
            <td class="text_tabledetail2">内容</td>
            <td><fm:textarea path="content"/></td>
        </tr>
        <tr>
            <td class="text_tabledetail2">图片</td>
            <td>
                <input type="file" name="imgPath" id="img1">
                <input type="file" name="imgPath" id="img2">
            </td>
        </tr>
        <tr>
            <td colspan="2">${error}</td>
        </tr>
        <tr>
            <td style="text-align:center;" colspan="2">
                <button type="submit" class="page-btn" name="save">保存</button>
                <input type="reset" value="重置">
            </td>
        </tr>
    </table>
</fm:form>
</body>
</html>

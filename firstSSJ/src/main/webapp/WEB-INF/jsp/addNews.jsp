<%--
  User: zhouganqing
  Date: 2020/7/26
  Time: 11:26
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加新闻</title>
</head>
<body>
<form name="loginForm" id="loginForm" action="${pageContext.request.contextPath}/news/addNews" method="post" enctype="multipart/form-data">
    <table class="tb" border="0" cellspacing="5" cellpadding="0" align="center">
        <tr><td align="center" colspan="2" style="text-align:center;" class="text_tabledetail2">添加新闻</td></tr>
        <tr>
            <td class="text_tabledetail2">标题</td>
            <td><input type="text" name="title" value=""/></td>
        </tr>
        <tr>
            <td class="text_tabledetail2">内容</td>
            <td><input type="text" name="content" value=""/></td>
        </tr>
        <tr>
            <td class="text_tabledetail2">图片</td>
            <td><input type="file" name="imgPath" id="imgPath"></td>
        </tr>
        <tr>
            <td colspan="2" style="color: red">${error}</td>
        </tr>
        <tr>
            <td style="text-align:center;" colspan="2">
                <button type="submit" class="page-btn" name="save">保存</button>
                <input type="reset" value="重置">
            </td>
        </tr>
    </table>
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: 林俊雷
  Date: 2023/4/17
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>管理员登录</title>
</head>
<body>
管理员登录：
<form action="adminLogin" name="adminLogin" method="get">
    账号：<input type="text" name="adminName">
    密码：<input type="password" name="adminPwd">
    <input type="submit" value="提交">
    <br>
    ${msg}
</form>

</body>
</html>

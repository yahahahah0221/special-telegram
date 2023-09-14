<%--
  Created by IntelliJ IDEA.
  User: 林俊雷
  Date: 2023/4/16
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
用户信息<br>
<c:forEach items="${useru}" var="user">
    ${user.id},${user.name}
</c:forEach>
</body>
</html>

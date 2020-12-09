<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/9 0009
  Time: 下午 4:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/loginServlet">
    <input type="text" name="username" placeholder="请输入账号"><br>
    <input type="password" name="password" placeholder="请输入密码"><br>
    <input type="submit" value="登录">
</form>
<div color="red">${msg}</div>
</body>
</html>

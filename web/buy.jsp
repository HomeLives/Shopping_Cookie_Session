<%--
  Created by IntelliJ IDEA.
  User: 86180
  Date: 2020/12/9
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>购物车</title>
</head>
<body>
<h1 style="text-align: center">用户：${sessionScope.username} 的购物车</h1>
<table border="1" width="600px" align="center">
    <tr>
        <td>编号</td>
        <td>名称</td>
        <td>价格</td>
        <td>描述</td>
    </tr>
    <c:forEach items="${sessionScope.products}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.desc}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

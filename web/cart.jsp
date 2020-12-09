<%@ page import="com.hrbu.java3.dao.ProductDao" %>
<%@ page import="com.hrbu.java3.dao.ProductDaoImpl" %>
<%@ page import="com.hrbu.java3.vo.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/9 0009
  Time: 下午 5:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>商品</title>
</head>
<body>
<%
    ProductDao product = new ProductDaoImpl();
    List<Product> list = product.getAll();
    request.setAttribute("list", list);
%>
<h1 style="text-align: center">商品列表</h1>
<table border="1" width="600px" align="center">
    <tr>
        <td>编号</td>
        <td>名称</td>
        <td>价格</td>
        <td>描述</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${list}" var="product" varStatus="s">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.desc}</td>
            <td><a href="${pageContext.request.contextPath}/cartServlet?id=${product.id}">添加</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td>
            <c:if test="${empty sessionScope.username}">
                <a href="${pageContext.request.contextPath}/login.jsp">结算</a>
            </c:if>
            <c:if test="${not empty sessionScope.username}">
                <a href="${pageContext.request.contextPath}/buy.jsp">结算</a>
            </c:if>
        </td>
    </tr>
</table>
</body>
</html>

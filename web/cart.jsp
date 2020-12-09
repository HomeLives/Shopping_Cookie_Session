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
<html>
<head>
    <title>商品</title>
</head>
<body>
<table border="1" width="600px">
    <tr>
        <td>编号</td>
        <td>名称</td>
        <td>价格</td>
        <td>描述</td>
    </tr>
    <%
        ProductDao product = new ProductDaoImpl();
        List<Product> list = product.getAll();
    %>
</table>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26/03/2022
  Time: 12:32 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Product</h1>
<p>
    <a href="/Product?action=create">Create new product</a>
</p>
<form method="get">
    <input type="text" name="name" placeholder="Enter product name">
    <input type="submit" value="search" name="action">
</form>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<table border="1">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Price</td>
        <td>Description</td>
        <td>Producer</td>
    </tr>
    <c:forEach items='${requestScope["products"]}' var="product">
        <tr>
            <td>${product.getId()}</td>
            <td><a href="/Product?action=view&name=${product.getName()}">${product.getName()}</a></td>
            <td>${product.getPrice()}</td>
            <td><a href="/Product?action=edit&name=${product.getName()}">edit</a></td>
            <td><a href="/Product?action=delete&name=${product.getName()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

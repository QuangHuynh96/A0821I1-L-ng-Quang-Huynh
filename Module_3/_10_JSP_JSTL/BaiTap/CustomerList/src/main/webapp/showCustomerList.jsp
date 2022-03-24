<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24/03/2022
  Time: 5:11 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<table border="1px" style="border-collapse: collapse">
    <tr>
        <th> Danh sach khach hang</th>
    </tr>
    <tr>
        <td>Name</td>
        <td>Birtday</td>
        <td>Address</td>
    </tr>
    <c:forEach items ="${CustomerList}" var = "customer">
        <tr>
            <td>${customer.name}</td>
            <td>${customer.birtday}</td>
            <td>${customer.address}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

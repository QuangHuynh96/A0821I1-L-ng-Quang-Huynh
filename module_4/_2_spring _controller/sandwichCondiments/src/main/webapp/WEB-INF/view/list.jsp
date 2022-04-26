<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26/04/2022
  Time: 8:10 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SandwictCondiment</title>
    <script src="/jquery/jquery-3.6.0.min.js"></script>
    <script src="/datatables/js/jquery.dataTables.js"></script>
    <link rel="stylesheet" href="/bootstrap-4.6.1-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/datatables/css/dataTables.bootstrap4.min.css">
    <script src="/bootstrap-4.6.1-dist/js/bootstrap.min.js"></script>
    <script src="/datatables/js/dataTables.bootstrap4.min.js"></script>
</head>
<body>
<table class="table table-sm">
    <thead>
    <tr>
        <th scope="col">Condiment</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="condiment" items="${condimentList}">
        <tr>
            <td>${condiment}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

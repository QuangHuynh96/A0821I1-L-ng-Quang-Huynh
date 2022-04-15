<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/04/2022
  Time: 9:20 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book Management Application</title>
    <script src="/jquery/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="/bootstrap-4.6.1-dist/css/bootstrap.min.css">
    <script src="/bootstrap-4.6.1-dist/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-light bg-light ">
    <h5>Create New Auther</h5>
</nav>
<c:if test="${requestScope['message'] != null}">
    <nav class="navbar navbar-light bg-light ">
        <h6 style="color: green">${requestScope['message']}</h6>
    </nav>
</c:if>
<div style="width: 700px; margin: auto">
    <form action="/Auther?action=create" method="post">
        <div class="form-group">
            <label for="name">Name</label>
            <c:if test="${auther != null}">
                <input type="text" class="form-control" id="name" name="name" value="${auther.name}">
            </c:if>
            <c:if test="${auther == null}">
                <input type="text" class="form-control" id="name" name="name">
            </c:if>
        </div>
        <div class="form-group">
            <label for="nickName">Nickname</label>
            <c:if test="${auther != null}">
                <input type="text" class="form-control" id="nickName" name="nickName" value="${auther.nickName}">
            </c:if>
            <c:if test="${auther == null}">
                <input type="text" class="form-control" id="nickName" name="nickName">
            </c:if>
<%--            <span style="color: darkred">${messList[0]}</span>--%>
        </div>
        <div class="form-group">
            <label for="address">Address</label>
            <c:if test="${auther != null}">
                <input type="text" class="form-control" id="address" name="address" value="${auther.address}">
            </c:if>
            <c:if test="${auther == null}">
                <input type="text" class="form-control" id="address" name="address">
            </c:if>
        </div>
        <button type="submit" class="btn btn-primary">Create</button>
    </form>
</div>
</body>
</html>

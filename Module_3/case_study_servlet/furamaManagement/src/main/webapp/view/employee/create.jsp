<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04/04/2022
  Time: 2:15 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>create Employee</title>
    <script src="/jquery/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="/bootstrap-4.6.1-dist/css/bootstrap.min.css">
    <script src="/bootstrap-4.6.1-dist/js/bootstrap.min.js"></script>

    <style>
        label{
            padding-left: 16px;
        }
    </style>
</head>

<body>
<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand" href="index.jsp">Home</a>
    <a href="/Employee?action=findByAll" class="btn btn-success" >
        back to employee list
    </a>
</nav>
<c:if test="${requestScope['message'] != null}">
    <nav class="navbar navbar-light bg-light justify-content-sm-center">
        <h6 style="color: green">${requestScope['message']}</h6>
    </nav>
</c:if>
<div style="width: 700px; margin: auto">
    <nav class="navbar ">
        <h5>Create New Employee</h5>
    </nav>
    <form action="/Employee?action=create" method="post">
        <div class="form-group">
            <label for="fullName">Full name</label>
            <input type="text" class="form-control" id="fullName" aria-describedby="emailHelp" name="fullName">
        </div>
        <div class="form-group">
            <label for="birtday">birtday</label>
            <input type="date" class="form-control" id="birtday" name="birtday">
        </div>
        <div class="form-group">
            <label for="idCard"> ID card</label>
            <input type="number" class="form-control" id="idCard" name="idCard">
        </div>
        <div class="form-group">
            <label for="salary"> Salary</label>
            <input type="number" class="form-control" id="salary" name="salary">
        </div>
        <div class="form-group">
            <label for="phoneNumber"> Phone number</label>
            <input type="number" class="form-control" id="phoneNumber" name="phoneNumber">
        </div>
        <div class="form-group">
            <label for="email"> Email</label>
            <input type="email" class="form-control" id="email" name="email">
            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>
        <div class="form-group">
            <label for="address"> address</label>
            <input type="text" class="form-control" id="address" name="address">
        </div>
        <div class="form-group">
            <label for="location">Location</label>
            <select class="custom-select" id="location" name="location">
                <c:forEach items="${locationList}" var="location">
                    <option value="<c:out value='${location.id}'/>"><c:out value='${location.ten}'/></option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="level">Level</label>
            <select class="custom-select" id="level" name="level">
                <c:forEach items="${levelList}" var="level">
                    <option value="<c:out value='${level.id}'/>"><c:out value='${level.ten}'/></option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="part">Part</label>
            <select class="custom-select" id="part" name="part">
                <c:forEach items="${partList}" var="part">
                    <option value="<c:out value='${part.id}'/>"><c:out value='${part.ten}'/></option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Create</button>
    </form>
</div>
</body>
</html>

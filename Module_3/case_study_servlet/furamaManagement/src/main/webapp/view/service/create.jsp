<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 01/04/2022
  Time: 11:10 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>create Customer</title>
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
    <a href="/Service?action=findByAll" class="btn btn-success" >
        back to service list
    </a>
</nav>
<c:if test="${requestScope['message'] != null}">
    <nav class="navbar navbar-light bg-light justify-content-sm-center">
        <h6 style="color: green">${requestScope['message']}</h6>
    </nav>
</c:if>
<div style="width: 700px; margin: auto">
    <nav class="navbar ">
        <h5>Create New Service</h5>
    </nav>
    <form action="/Service?action=create" method="post">
        <div class="form-group">
            <label for="name">Service name</label>
            <input type="text" class="form-control" id="name" aria-describedby="emailHelp" name="name">
        </div>
        <div class="form-group">
            <label for="rentalType">Rental type</label>
            <select class="custom-select" id="rentalType" name="rentalType">
                <c:forEach items="${kieuThueList}" var="type">
                    <option value="<c:out value='${type.id}'/>"><c:out value='${type.ten}'/></option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="serviceType">Rental type</label>
            <select class="custom-select" id="serviceType" name="serviceType">
                <c:forEach items="${loaiDichVuList}" var="type">
                    <option value="<c:out value='${type.id}'/>"><c:out value='${type.ten}'/></option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="area">Area</label>
            <input type="number" class="form-control" id="area" name="area">
        </div>
        <div class="form-group">
            <label for="rentalCosts">Rental costs</label>
            <input type="text" class="form-control" id="rentalCosts" name="rentalCosts">
        </div>
        <div class="form-group">
            <label for="maximumMenber">Maximum menber</label>
            <input type="number" class="form-control" id="maximumMenber" name="maximumMenber">
        </div>
        <div class="form-group">
            <label for="roomStandard"> Room standard</label>
            <select class="custom-select" id="roomStandard" name="roomStandard">
                <option value="vip">Vip</option>
                <option value="normal">Normal</option>
            </select>
        </div>
        <div class="form-group">
            <label for="description"> Description</label>
            <input type="text" class="form-control" id="description" name="description">
        </div>
        <div class="form-group">
            <label for="poolArea">Pool area</label>
            <input type="number" class="form-control" id="poolArea" name="poolArea">
        </div>
        <div class="form-group">
            <label for="floors"> Floors</label>
            <input type="text" class="form-control" id="floors" name="floors">
        </div>
        <button type="submit" class="btn btn-primary">Create</button>
    </form>
</div>
</body>
</html>

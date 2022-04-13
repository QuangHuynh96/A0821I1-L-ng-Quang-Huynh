<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02/04/2022
  Time: 8:15 CH
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
    <a href="/Contract?action=findByAll" class="btn btn-success" >
        back to contract list
    </a>
</nav>
<c:if test="${requestScope['message'] != null}">
    <nav class="navbar navbar-light bg-light ">
        <h6 style="color: green">${requestScope['message']}</h6>
    </nav>
</c:if>
<div style="width: 700px; margin: auto">
    <nav class="navbar ">
        <h5>Create New Contract</h5>
    </nav>
    <form action="/Contract?action=create" method="post">
        <div class="form-group">
            <label for="employee">Employee</label>
            <select class="custom-select" id="employee" name="employeeId">
                <option>Enter employee</option>
                <c:forEach items="${employeeList}" var="employee">
                    <option value="<c:out value='${employee.id}'/>"><c:out value='${employee.toString()}'/></option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="customer">Customer</label>
            <select class="custom-select" id="customer" name="customerId">
                <option>Enter customer</option>
                <c:forEach items="${customerList}" var="customer">
                    <option value="<c:out value='${customer.id}'/>"><c:out value='${customer.toString()}'/></option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="service">Service</label>
            <select class="custom-select" id="service" name="serviceId">
                <option>Enter service</option>
                <c:forEach items="${dichVuList}" var="service">
                    <option value="<c:out value='${service.id}'/>"><c:out value='${service.toString()}'/></option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="startDay">Start day</label>
            <input type="date" class="form-control" id="startDay" name="startDay">
        </div>
        <div class="form-group">
            <label for="endDay">End day</label>
            <input type="date" class="form-control" id="endDay" name="endDay">
        </div>
        <div class="form-group">
            <label for="rentalCosts">rental costs</label>
            <input type="number" class="form-control" id="rentalCosts" name="rentalCosts">
        </div>
        <button type="submit" class="btn btn-primary">Create</button>
    </form>
</div>
</body>
</html>
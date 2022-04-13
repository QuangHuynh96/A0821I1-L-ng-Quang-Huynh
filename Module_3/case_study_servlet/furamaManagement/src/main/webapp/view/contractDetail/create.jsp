<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05/04/2022
  Time: 7:36 CH
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
</nav>

<c:if test="${requestScope['message'] != null}">
    <nav class="navbar navbar-light bg-light justify-content-sm-center">
        <h6 style="color: green">${requestScope['message']}</h6>
    </nav>
</c:if>
<div style="width: 700px; margin: auto">
    <nav class="navbar ">
        <h5>Create New contract detail</h5>
    </nav>
    <form action="/Contract?action=createContractDetail" method="post">
        <div class="form-group">
            <label for="contract">Contract</label>
            <select class="custom-select" id="contract" name="contract">
                <option>Enter contract</option>
                <c:forEach items="${contractList}" var="contract">
                    <option value="<c:out value='${contract.id}'/>">
                        <c:out value='contract day: ${contract.ngayLamHopDong}'/>
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="accompaniedService">accompanied Service</label>
            <select class="custom-select" id="accompaniedService" name="service">
                <option>Enter accompanied</option>
                <c:forEach items="${accompaniedServiceList}" var="service">
                    <option value="<c:out value='${service.id}'/>">
                        <c:out value='${service.name}'/>
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="amount">Amount</label>
            <input type="number" class="form-control" id="amount" name="amount">
        </div>
        <button type="submit" class="btn btn-primary">Create</button>
    </form>
</div>
</body>
</html>
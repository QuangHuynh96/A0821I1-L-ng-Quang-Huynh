<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 01/04/2022
  Time: 3:15 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Customer</title>
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
    <nav class="navbar navbar-light bg-light">
        <h6 style="color: green">${requestScope['message']}</h6>
    </nav>
</c:if>
<div style="width: 700px; margin: auto">
    <nav class="navbar ">
        <h5>Edit Customer</h5>
    </nav>
    <form action="/Customer?action=edit" method="post">
        <div class="form-group">
            <label for="customerId">ID: ${customer.id}</label>
            <input value="${customer.id}" type="hidden" class="form-control" id="customerId" aria-describedby="emailHelp" name="customerId">
        </div>
        <div class="form-group">
            <label for="fullName">Full name</label>
            <input value="${customer.ten}" type="text" class="form-control" id="fullName" aria-describedby="emailHelp" name="fullName">
        </div>
        <div class="form-group">
            <label for="customerType">Customer type</label>
            <select class="custom-select" id="customerType" name="idCustomerType">
                <c:forEach items="${customerTypeList}" var="type">
                            <c:if test="${customer.idLoaikhach == type.id}">
                                <option selected value="<c:out value='${type.id}'/>">
                                <c:out value="${type.ten}"/>
                                </option>
                            </c:if>
                            <c:if test="${customer.idLoaikhach != type.id}">
                                <option value="<c:out value='${type.id}'/>">
                                    <c:out value="${type.ten}"/>
                                </option>
                            </c:if>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="birtday">birtday</label>
            <input value="${customer.ngaySinh}" type="date" class="form-control" id="birtday" name="birtday">
        </div>
        <div class="form-group">
            <label for="gender"> gender</label>
            <select class="custom-select" id="gender" name="gender">
                <option value="nam">Nam</option>
                <option value="nu">Nu</option>
                <option value="other">other</option>
            </select>
            <%--            <label for="gender"> Gender</label>--%>
            <%--            <input type="text" class="form-control" id="gender" name="gender">--%>
        </div>
        <div class="form-group">
            <label for="idCard"> ID card</label>
            <input value="${customer.cmnd}"  type="number" class="form-control" id="idCard" name="idCard">
        </div>
        <div class="form-group">
            <label for="phoneNumber"> Phone number</label>
            <input value="${customer.soDienThoai}"  type="number" class="form-control" id="phoneNumber" name="phoneNumber">
        </div>
        <div class="form-group">
            <label for="email"> Email</label>
            <input value="${customer.email}"  type="email" class="form-control" id="email" name="email">
            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>
        <div class="form-group">
            <label for="address"> address</label>
            <input value="${customer.diaChi}"  type="text" class="form-control" id="address" name="address">
        </div>
        <%--    <div class="form-group form-check">--%>
        <%--        <input type="checkbox" class="form-check-input" id="exampleCheck1">--%>
        <%--        <label class="form-check-label" for="exampleCheck1">Check me out</label>--%>
        <%--    </div>--%>
        <button type="submit" class="btn btn-primary">Update</button>
    </form>
</div>
</body>
</html>

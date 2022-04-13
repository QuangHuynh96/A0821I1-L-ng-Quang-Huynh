<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 13/04/2022
  Time: 8:03 CH
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
    <h5>Update Book</h5>
</nav>
<c:if test="${requestScope['message'] != null}">
    <nav class="navbar navbar-light bg-light ">
        <h6 style="color: green">${requestScope['message']}</h6>
    </nav>
</c:if>
<div style="width: 700px; margin: auto">
    <form action="/Book?action=update" method="post">
        <div class="form-group">
            <label for="id">ID: ${book.id}</label>
            <input type="hidden" class="form-control " id="id" name="id" value="${book.id}">
        </div>
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" name="name" value="${book.name}">
        </div>
        <div class="form-group">
            <label for="price">price</label>
            <input type="text" class="form-control" id="price" name="price" value="${book.price}">
<%--            <span style="color: darkred">${messList[0]}</span>--%>
        </div>
        <div class="form-group">
            <label for="idAuther">Auther</label>
            <select class="form-control" name="idAuther" id="idAuther">
                <c:forEach items="${autherList}" var="auther">
                    <c:if test="${auther.id == book.idAuther}">
                        <option selected value="${auther.id}">${auther.name}</option>
                    </c:if>
                    <c:if test="${auther.id != book.idAuther}">
                        <option value="${auther.id}">${auther.name}</option>
                    </c:if>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
    </form>
</div>
</body>
</html>
</html>

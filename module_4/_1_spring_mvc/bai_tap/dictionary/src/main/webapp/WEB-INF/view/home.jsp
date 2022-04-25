<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25/04/2022
  Time: 11:34 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dictionary</title>
    <script src="/jquery/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="/bootstrap-4.6.1-dist/css/bootstrap.min.css">
    <script src="/bootstrap-4.6.1-dist/js/bootstrap.min.js"></script>
</head>

<body>
<div style="width: 700px; margin: auto">
    <form action="/translate" method="get">
        <div class="form-group">
            <label for="english">English</label>
            <input type="text" class="form-control" id="english" name="english">
        </div>
        <c:if test="${result != null}">
            <nav class="navbar navbar-light bg-light justify-content-sm-center">
                <h5 style="color: green">${result}</h5>
            </nav>
        </c:if>
        <button type="submit" class="btn btn-primary">Translate</button>
    </form>
</div>
</body>
</html>

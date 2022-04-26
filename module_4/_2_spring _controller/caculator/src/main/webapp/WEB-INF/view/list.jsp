<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26/04/2022
  Time: 8:59 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Result</title>
    <script src="/jquery/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="/bootstrap-4.6.1-dist/css/bootstrap.min.css">
    <script src="/bootstrap-4.6.1-dist/js/bootstrap.min.js"></script>
</head>
<body>
<%--<form action="/caculator" method="post">--%>
<%--    <div class="form-group">--%>
<%--        <label for="number1">number1</label>--%>
<%--        <input type="number" class="form-control" id="number1" name="number1">--%>
<%--    </div>--%>
<%--    <div class="form-group">--%>
<%--        <label for="number2">number1</label>--%>
<%--        <input type="number" class="form-control" id="number2" name="number2">--%>
<%--    </div>--%>
<%--    <hr>--%>
<%--    <button type="submit" class="button" name="caculator" value="+">(+)</button>--%>
<%--    <button type="submit" class="button" name="caculator" value="-">(-)</button>--%>
<%--    <button type="submit" class="button" name="caculator" value="*">(*)</button>--%>
<%--    <button type="submit" class="button" name="caculator" value="/">(/)</button>--%>
<%--</form>--%>
<c:if test="${result != null}">
    <nav class="navbar navbar-light bg-light ">
        <h6 style="color: green">Result: ${result}</h6>
    </nav>
</c:if>
</body>
</html>

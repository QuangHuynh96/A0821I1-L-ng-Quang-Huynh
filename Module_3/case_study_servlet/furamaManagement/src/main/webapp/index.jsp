<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31/03/2022
  Time: 9:08 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Customer Management Application</title>
  <script src="/jquery/jquery-3.6.0.min.js"></script>
  <link rel="stylesheet" href="/bootstrap-4.6.1-dist/css/bootstrap.min.css">
  <script src="/bootstrap-4.6.1-dist/js/bootstrap.min.js"></script>
</head>
<body>
    <nav class="navbar navbar-light bg-light">
      <h1 class="navbar-brand " style="color: #1c7430; font-family: -apple-system; font-weight: bold " href="#">FURAMA resort</h1>
    </nav>

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <a class="navbar-brand" href="index.jsp">Home</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <a class="nav-link" href="/Customer">Customer</a>
          </li>
          <li class="nav-item">
            <a class="nav-link disabled" href="#">Employees (disabled)</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/Service">Service</a>
          </li>
          <li class="nav-item">
            <a class="nav-link disabled" href="/Contract">Contract(disabled)</a>
          </li>
        </ul>
      </div>
    </nav>
    <c:if test='${requestScope["content"] != null}'>
        <div class="list-group" >
            ${requestScope["content"]}
        </div>
    </c:if>
</body>
</html>

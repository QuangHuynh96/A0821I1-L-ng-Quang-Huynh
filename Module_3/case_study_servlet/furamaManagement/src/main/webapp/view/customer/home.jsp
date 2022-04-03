<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31/03/2022
  Time: 10:01 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>User Management Application</title>
    <script src="/jquery/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="/bootstrap-4.6.1-dist/css/bootstrap.min.css">
    <script src="/bootstrap-4.6.1-dist/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand" href="#">Logo</a>
</nav>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/Furama">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <%--      <li class="nav-item active">--%>
            <%--        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>--%>
            <%--      </li>--%>
            <li class="nav-item">
                <a class="nav-link" href="/Customer">Customer</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Employees</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Service</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Contract</a>
            </li>
            <%--            <li class="nav-item dropdown">--%>
            <%--                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-expanded="false">--%>
            <%--                    Customer--%>
            <%--                </a>--%>
            <%--                <div class="dropdown-menu" aria-labelledby="navbarDropdown">--%>
            <%--                    <a class="dropdown-item" href="/Furama?action=create&object=customer">Create customer</a>--%>
            <%--                    <a class="dropdown-item" href="#">Another action</a>--%>
            <%--                    <div class="dropdown-divider"></div>--%>
            <%--                    <a class="dropdown-item" href="#">Show all customer list</a>--%>
            <%--                </div>--%>
            <%--            </li>--%>
            <%--            <li class="nav-item">--%>
            <%--                <a class="nav-link disabled">Disabled</a>--%>
            <%--            </li>--%>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
<c:if test='${requestScope["content"] != null}'>
    <div class="list-group">
            ${requestScope["content"]}
            <%--  <a href="/Customer?action=create" class="list-group-item list-group-item-action active" aria-current="true">--%>
            <%--    Create new customer>--%>
            <%--  </a>--%>
            <%--  <a href="/Customer?action=findByAll" class="list-group-item list-group-item-action">Show customer list</a>--%>
    </div>
</c:if>
</body>
</html>


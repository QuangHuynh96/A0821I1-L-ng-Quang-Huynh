<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25/04/2022
  Time: 8:08 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Convert</title>
    <script src="/jquery/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="/bootstrap-4.6.1-dist/css/bootstrap.min.css">
    <script src="/bootstrap-4.6.1-dist/js/bootstrap.min.js"></script>
  </head>

  <body>
    <div style="width: 700px; margin: auto">
      <form action="/convert" method="get">
        <div class="form-group">
          <label for="usd">USD</label>
            <input type="text" class="form-control" id="usd" name="usd">
          <label for="rate">Ty gia</label>
            <input type="text" class="form-control" id="rate" name="rate">
        </div>
        <button type="submit" class="btn btn-primary">convert</button>
      </form>
    </div>
  </body>
</html>

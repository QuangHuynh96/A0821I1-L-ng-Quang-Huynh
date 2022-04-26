<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26/04/2022
  Time: 7:44 CH
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
    <form action="/save" method="post">
      <div class="form-check form-check-inline">
        <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="Lettuce" name="condiment">
        <label class="form-check-label" for="inlineCheckbox1">Lettuce</label>
      </div>
      <div class="form-check form-check-inline">
        <input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="Tomato" name="condiment">
        <label class="form-check-label" for="inlineCheckbox2">Tomato</label>
      </div>
      <div class="form-check form-check-inline">
        <input class="form-check-input" type="checkbox" id="inlineCheckbox3" value="Mustard" name="condiment">
        <label class="form-check-label" for="inlineCheckbox3">Mustard </label>
      </div>
      <div class="form-check form-check-inline">
        <input class="form-check-input" type="checkbox" id="inlineCheckbox4" value="Sprouts" name="condiment">
        <label class="form-check-label" for="inlineCheckbox4">Sprouts </label>
      </div>
      <hr>
      <button type="submit" class="button">save</button>
    </form>
  </body>
</html>

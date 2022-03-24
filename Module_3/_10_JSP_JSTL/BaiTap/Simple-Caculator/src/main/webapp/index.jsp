<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24/03/2022
  Time: 9:29 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Simple Calculator</title>
  </head>
  <body>
  <form action="/Calculaor" method="post">
    <h1>Simple Calculator</h1>
    <fieldset >
      <legend> Calculator</legend>
      <div>
        <label for="disabledTextInput" class="">First Openrand</label>
        <input type="number" id="disabledTextInput" name="first-openrand" >
      </div>
      <div>
        <label for="disabledSelect" >Operator</label>
        <select id="disabledSelect" class="form-select" name="operator">
          <option name="addition" value="addition">addition</option>
          <option name="subtraction" value="subtraction">subtraction</option>
          <option name="multiplication" value="multiplication">multiplication</option>
          <option name="division" value="division">division</option>
        </select>
      </div>
      <div>
        <label for="disabledTextInput2" class="">First Openrand</label>
        <input type="number" id="disabledTextInput2" name="second-openrand" >
      </div>
      <button type="submit" >calculator</button>
    </fieldset>
  </form>
  </body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19/03/2022
  Time: 11:06 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Currency Converter</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>Product Discount Calculator</h2>
<form action="/display-discount" method="post">
  <label>Mô tả của sản phẩm: </label><br/>
  <input type="text" name="Description" placeholder="Description" value=""/><br/><br/>
  <label>Giá niêm yết của sản phẩm:(VND) </label><br/>
  <input type="text" name="ListPrice" placeholder="ListPrice" value=""/><br/><br/>
  <label>Tỷ lệ chiết khấu (%): </label><br/>
  <input type="text" name="DiscountPercent" placeholder="DiscountPercent" value=""/><br/><br/>
  <input type = "submit" id = "submit" value = "Calculate Discount"/>
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 29/03/2022
  Time: 11:01 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/Users">List All Users</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2> Find By Country</h2>
            </caption>
            <tr>
                <th>User Country:</th>
                <td>
                    <input type="text" name="country" id="country" size="45"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="search"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

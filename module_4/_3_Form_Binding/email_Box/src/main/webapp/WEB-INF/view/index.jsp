<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27/04/2022
  Time: 8:24 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email</title>
</head>
<body>
<form:form action="" method="post" modelAttribute="updateEmailConfig">
    <label for="language">Language :</label>
    <form:select id="language" path="language" items="${languages}">
        <form:option selected="true" value="${updateEmailConfig.language}"></form:option>
    </form:select>
    <br>
    <br>
    <label id="pagesize">Page Size</label>
    <form:select id="pagesize" path="pageSize" items="${pageSizes}">
        <form:option selected="true" value="${updateEmailConfig.pageSize}"></form:option>
    </form:select>
    <br>
    <br>
    <label id="spamsfillter">Spams fillter</label>
    <form:radiobutton id="spamsfillter" path="spamsFillter" value="true"></form:radiobutton>
    <br>
    <br>
    <label id="">Signature</label>
    <br>
<%--    <form:textarea path="signature" rows="5" cols="50">${emailConfig.signature}</form:textarea>--%>
    <form:textarea path="signature" rows="5" cols="50" value="${emailConfig.signature}" />${emailConfig.signature}
    <br>
    <input type="submit" value="update">
</form:form>
</body>
</html>

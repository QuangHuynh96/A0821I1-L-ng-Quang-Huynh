<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/04/2022
  Time: 11:01 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book Management Application</title>
    <script src="/jquery/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="/bootstrap-4.6.1-dist/css/bootstrap.min.css">
    <script src="/bootstrap-4.6.1-dist/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-light bg-light ">
    <h5>Update Benh An</h5>
</nav>
<c:if test="${requestScope['message'] != null}">
    <nav class="navbar navbar-light bg-light ">
        <h6 style="color: green">${requestScope['message']}</h6>
    </nav>
</c:if>
<div style="width: 700px; margin: auto">
    <form action="/BenhAn?action=update" method="post">
        <div class="form-group">
            <label for="idBenhAn">ID benh an: ${benhAn.idBenhAn}</label>
            <input type="hidden" class="form-control " id="idBenhAn" name="idBenhAn" value="${benhAn.idBenhAn}">
        </div>
        <div class="form-group">
            <label for="idBenhNhan">ID benh nhan: ${benhAn.idBenhNhan}</label>
            <input type="hidden" class="form-control " id="idBenhNhan" name="idBenhNhan" value="${benhAn.idBenhNhan}">
        </div>
        <div class="form-group">
            <label for="ngayNhapVien">Ngay nhap vien</label>
                <input type="text" class="form-control" id="ngayNhapVien" name="ngayNhapVien" value="${ benhAn.getNgayNhapVien()}">
        </div>
        <div class="form-group">
            <label for="ngayRaVien">ngay Ra Vien</label>
                <input type="text" class="form-control" id="ngayRaVien" name="ngayRaVien" value="${benhAn.getNgayRaVien()}">
        </div>
        <div class="form-group">
            <label for="lyDoNhapVien">ly do</label>
            <input type="text" class="form-control" id="lyDoNhapVien" name="lyDoNhapVien" value="${benhAn.getLyDoNhapVien()}">
        </div>
        <%--            <span style="color: darkred">${messList[0]}</span>--%>
        <button type="submit" class="btn btn-primary">Update</button>
    </form>
</div>
</body>
</html>
</html>

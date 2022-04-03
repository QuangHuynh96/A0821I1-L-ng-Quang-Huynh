<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03/04/2022
  Time: 8:17 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Service list</title>
    <script src="/jquery/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="/bootstrap-4.6.1-dist/css/bootstrap.min.css">
    <script src="/bootstrap-4.6.1-dist/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand align-content-center" href="index.jsp">Home</a>
</nav>
<nav class="navbar navbar-light bg-light">
    <h5 style="color: green">Service lists</h5>
    <a href="/Service?action=create" class="btn btn-success" >
        Create new service
    </a>
</nav>
<table class="table">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Kieu thue</th>
        <th scope="col">Loai dich vu</th>
        <th scope="col">Ten</th>
        <th scope="col">Dien tich</th>
        <th scope="col">Chi phi thue</th>
        <th scope="col">So nguoi toi da</th>
        <th scope="col">Tieu chuan phong</th>
        <th scope="col">Mo ta tien nghi khac</th>
        <th scope="col">Dien tich ho boi</th>
        <th scope="col">So tang</th>
        <th scope="col">Edit</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="dichVu" items="${dichVuList}">
        <tr>
            <th scope="row">
                <c:out value="${dichVu.id}"/>
            </th>
            <td>
                <c:forEach items="${kieuThueList}" var="kieuThue">
                    <c:if test="${dichVu.idKieuThue == kieuThue.id}">
                        <c:out value="${kieuThue.ten}"/>
                    </c:if>
                </c:forEach>
            </td>
            <td>
                <c:forEach items="${loaiDichVuList}" var="loaiDichVu">
                    <c:if test="${dichVu.idLoaiDichVu == loaiDichVu.id}">
                        <c:out value="${loaiDichVu.ten}"/>
                    </c:if>
                </c:forEach>
            </td>
            <td><c:out value="${dichVu.ten}"/></td>
            <td><c:out value="${dichVu.dienTich}"/></td>
            <td><c:out value="${dichVu.chiPhiThue}"/></td>
            <td><c:out value="${dichVu.soNguoiToiDa}"/></td>
            <td><c:out value="${dichVu.tieuChuanPhong}"/></td>
            <td><c:out value="${dichVu.moTaTienNghiKhac}"/></td>
            <td><c:out value="${dichVu.dienTichHoBoi}"/></td>
            <td><c:out value="${dichVu.soTang}"/></td>
            <td>
                <a href="/Service?action=edit&id=${dichVu.id}" class="btn btn-light">Edit</a>
            </td>
            <td>
                <button onclick="infoDelete('${dichVu.id}', '${dichVu.ten}')" type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal">
                    Delete
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="/Service?action=delete" method="post">
                <div class="modal-body">
                    <input name="id" id="serviceId" hidden >
                    <span>Do you want to delete a sevice:</span>
                    <span type="text" id="serviceName" class="text-danger"></span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Delete</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    function infoDelete(id, name) {
        document.getElementById("serviceId").value= id;
        document.getElementById("serviceName").innerText= name;
    }
</script>
</body>
</html>

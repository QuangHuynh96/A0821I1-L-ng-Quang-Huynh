<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 06/04/2022
  Time: 8:24 CH
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
    <script src="/datatables/js/jquery.dataTables.js"></script>
    <link rel="stylesheet" href="/bootstrap-4.6.1-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/datatables/css/dataTables.bootstrap4.min.css">
    <script src="/bootstrap-4.6.1-dist/js/bootstrap.min.js"></script>
    <script src="/datatables/js/dataTables.bootstrap4.min.js"></script>
</head>
<body>
<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand align-content-center" href="index.jsp">Home</a>
</nav>
<nav class="navbar navbar-light bg-light">
    <h5 style="color: green">Danh sách khách hàng đang sử dụng dịch vụ của resort</h5>
    <a href="/Contract?action=create" class="btn btn-success" >
        Create new contract
    </a>
</nav>
<table id="tableList" class="table table-striped table-bordered">
    <thead>
    <tr>
        <th scope="col">Ten DV</th>
        <th scope="col">Nhan Vien</th>
        <th scope="col">Khach hang</th>
        <th scope="col">Dich vu</th>
        <th scope="col">Ngay lam hop dong</th>
        <th scope="col">Edit</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="record" items="${list}">
        <tr>
            <th scope="row">
                <c:forEach items="${dichVuList}" var="service">
                    <c:if test="${service.id == record.idDichVu}">
                        <c:out value="${service.ten}"/>
                    </c:if>
                </c:forEach>
            </th>
            <th scope="row">
                <c:out value="${record.ten}"/>
            </th>
            <th scope="row">
                <c:out value="${record.soDienThoai}"/>
            </th>
            <th scope="row">
                <c:out value="${record.tenDichVuDiKem}"/>
            </th>
            <th scope="row">
                <c:out value="${record.ngayLamHopDong}"/>
            </th>
            <td>
                <a href="/Service?action=edit&id=${record.idDichVu}" class="btn btn-light">Edit</a>
            </td>
            <td>
                <button onclick="infoDelete('${record.idDichVu}')" type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal">
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
                    <span>Do you want to delete this service:</span>
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
    }

    $(document).ready(
        function() {
            $('#tableList').dataTable(
                {"dom": 'lrtip',
                    "lengthChange": false,
                    "pageLength": 7
                }
            );
        }
    );
</script>
</body>
</html>
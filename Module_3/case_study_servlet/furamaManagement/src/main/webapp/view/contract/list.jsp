<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05/04/2022
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
    <h5 style="color: green">Contract lists</h5>
    <a href="/Contract?action=create" class="btn btn-success" >
        Create new contract
    </a>
</nav>
<table id="tableList" class="table table-striped table-bordered">
    <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Nhan Vien</th>
            <th scope="col">Khach hang</th>
            <th scope="col">Dich vu</th>
            <th scope="col">Ngay lam hop dong</th>
            <th scope="col">Ngay ket thuc</th>
            <th scope="col">Tien dat coc</th>
            <th scope="col">Edit</th>
            <th scope="col">Delete</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="contract" items="${contractList}">
            <tr>
                <th scope="row">
                    <c:out value="${contract.id}"/>
                </th>
                <td>
                    <c:forEach items="${employeeList}" var="employee">
                        <c:if test="${employee.id == contract.idNhanVien}">
                            <c:out value="${employee.ten}"/>
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach items="${customerList}" var="customer">
                        <c:if test="${contract.idKhachHang == customer.id}">
                            <c:out value="${customer.ten}"/>
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach items="${serviceList}" var="service">
                        <c:if test="${service.id == contract.idDichVu}">
                            <c:out value="${service.ten}"/>
                        </c:if>
                    </c:forEach>
                </td>
                <td><c:out value="${contract.ngayLamHopDong}"/></td>
                <td><c:out value="${contract.ngayKetThuc}"/></td>
                <td><c:out value="${contract.tienDatCoc}"/></td>
                <td>
                    <a href="/Contract?action=edit&id=${contract.id}" class="btn btn-light disabled">Edit(disable)</a>
                </td>
                <td>
                    <button onclick="infoDelete('${contract.id}')" type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal">
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
            <form action="/Contract?action=delete" method="post">
                <div class="modal-body">
                    <input name="id" id="contractId" hidden >
                    <span>Do you want to delete a contract:</span>
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
        document.getElementById("contractId").value= id;
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


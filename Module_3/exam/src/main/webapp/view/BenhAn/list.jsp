<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15/04/2022
  Time: 6:11 CH
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
    <h5 style="color: green">Benh an</h5>
    <a href="/BenhAn?action=create" class="btn btn-success" >
       tao benh an moi
    </a>
</nav>
<table id="tableList" class="table table-striped">
    <thead>
    <tr>
        <th scope="col">Ma benh an</th>
        <th scope="col">Ma benh nhan</th>
        <th scope="col">Ten benh nhan</th>
        <th scope="col">ngay nhap vien</th>
        <th scope="col">ngay ra vien</th>
        <th scope="col">ly do nhap vien</th>
        <th scope="col">edit</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="benhAn" items="${benhAnList}">
        <tr>
            <td>
                ${benhAn.idBenhAn}
            </td>
            <td>
                ${benhAn.idBenhNhan}
            </td>
            <td>
                <c:forEach items="${benhNhanList}" var="benhNhan">
                    <c:if test="${benhNhan.idBenhNhan == benhAn.idBenhNhan}">
                        ${benhNhan.ten}
                    </c:if>
                </c:forEach>
            </td>
            <td>
                ${benhAn.getNgayNhapVien()}
            </td>
            <td>${benhAn.getNgayRaVien()}
            </td>
            <td>
                ${benhAn.lyDoNhapVien}
            </td>
            <td>
                <a href="/BenhAn?action=update&id=${benhAn.idBenhAn}" class="btn btn-light">Edit</a>
            </td>
            <td>
                <button onclick="infoDelete('${benhAn.idBenhAn}')" type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal">
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
            <form action="/BenhAn?action=delete" method="post">
                <div class="modal-body">
                    <span>Ban muon xoa benh an khong co ma:  </span>
                    <input name="id" id="idBenhAn" style="border: none">

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
    function infoDelete(id) {
        document.getElementById("idBenhAn").value= id;
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

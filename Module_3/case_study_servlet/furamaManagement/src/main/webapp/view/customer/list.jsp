<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31/03/2022
  Time: 4:39 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer list</title>
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
    <h5 style="color: green">Customer lists</h5>
    <a href="/Customer?action=create" class="btn btn-success" >
        Create new customer
    </a>
</nav>
<table id="tableList" class="table table-striped table-bordered">
    <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Customer type</th>
            <th scope="col">Full name</th>
            <th scope="col">Birtday</th>
            <th scope="col">Gender</th>
            <th scope="col">ID card</th>
            <th scope="col">Phone Number</th>
            <th scope="col">Email</th>
            <th scope="col">Address</th>
            <th scope="col">Edit</th>
            <th scope="col">Delete</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="customer" items="${customerList}">
            <tr>
                <th scope="row">
                    <c:out value="${customer.id}"/>
                </th>
                <td>
                    <c:forEach items="${customerTypeList}" var="customerType">
                        <c:if test="${customer.idLoaikhach == customerType.id}">
                           <c:out value="${customerType.ten}"/>
                       </c:if>
                    </c:forEach>
                </td>
                <td><c:out value="${customer.ten}"/></td>
                <td><c:out value="${customer.ngaySinh}"/></td>
                <td>
                        <c:if test="${customer.gioiTinh}">
                            <c:out value="Nam"/>
                        </c:if>
                        <c:if test="${!customer.gioiTinh}">
                            <c:out value="Nữ"/>
                        </c:if>
                </td>
                <td><c:out value="${customer.cmnd}"/></td>
                <td><c:out value="${customer.soDienThoai}"/></td>
                <td><c:out value="${customer.email}"/></td>
                <td><c:out value="${customer.diaChi}"/></td>
                <td>
                    <a href="/Customer?action=edit&id=${customer.id}" class="btn btn-light">Edit</a>
                </td>
                <td>
                    <button onclick="infoDelete('${customer.id}', '${customer.ten}')" type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal">
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
                <form action="/Customer?action=delete" method="post">
                    <div class="modal-body">
                        <input name="id" id="customerId" hidden >
                        <span>Do you want to delete a customer:</span>
                        <span type="text" id="customerName" class="text-danger"></span>
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
        document.getElementById("customerId").value= id;
        document.getElementById("customerName").innerText= name;
    }

    $(document).ready(function() {
        $('#tableList').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        } );
    } );
</script>

</body>
</html>

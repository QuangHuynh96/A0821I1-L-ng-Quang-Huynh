<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/04/2022
  Time: 9:01 CH
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
    <h5 style="color: green">Ather List</h5>
    <form action="/Auther?action=search" method="post" class="form-inline my-2 my-lg-0">
        <input name="name" class="form-control mr-sm-2" type="search" placeholder="Name" aria-label="Search">
        <input name="nickName" class="form-control mr-sm-2" type="search" placeholder="Nick name" aria-label="Search">
        <input name="address" class="form-control mr-sm-2" type="search" placeholder="address" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
    <a href="/Auther?action=create" class="btn btn-success" >
        Create new Auther
    </a>
</nav>
<table id="tableList" class="table table-striped">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Nick name</th>
        <th scope="col">Address</th>
        <th scope="col">Edit</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="auther" items="${autherList}">
        <tr>
            <td>
                <c:out value="${auther.id}"/>
            </td>
            <td>
                <c:out value="${auther.name}"/>
            </td>
            <td>
                <c:out value="${auther.nickName}"/>
            </td>
            <td>
                <c:out value="${auther.address}"/>
            </td>
            <td>
                <a href="/Auther?action=update&id=${auther.id}" class="btn btn-light">Edit</a>
            </td>
            <td>
                <button onclick="infoDelete('${auther.id}')" type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal">
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
            <form action="/Auther?action=delete" method="post">
                <div class="modal-body">
                    <input name="id" id="autherId" hidden >
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
    function infoDelete(id) {
        document.getElementById("autherId").value= id;
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

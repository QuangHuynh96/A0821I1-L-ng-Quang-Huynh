<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28/03/2022
  Time: 10:18 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>User Management Application</title>
        <script src="/jquery/jquery-3.6.0.min.js"></script>
        <link rel="stylesheet" href="/bootstrap-4.6.1-dist/css/bootstrap.min.css">
        <script src="/bootstrap-4.6.1-dist/js/bootstrap.min.js"></script>

</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/Users">List All Users</a>
    </h2>
    <h2>
        <a href="/Users?action=create">Add New User</a>
    </h2>
    <h2>
        <a href="/Users?action=findByCountry">Find By Country</a>
    </h2>
    <c:if test='${requestScope["result"] != null}'>
        <span class="message">${requestScope["result"]} result </span>
    </c:if>
</center>
    <div align="center">
        <form action="/Users?action=sort" method="post">
        <button type="submit" name="sort" value="asc">Xếp tăng dần</button>
        <button type="submit" name="sort" value="desc">Xếp giảm dần</button>
        </form>
        <table border="1" cellpadding="5">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="user" items="${userList}">
                <tr>
                    <td><c:out value="${user.id}"/></td>
                    <td><c:out value="${user.name}"/></td>
                    <td><c:out value="${user.email}"/></td>
                    <td><c:out value="${user.country}"/></td>
                    <td>
                        <a href="/Users?action=edit&id=${user.id}">Edit</a>
                        <button onclick="infoDelete(${user.id})" type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
                            Delete
                        </button>
    <%--                    <a href="/Users?action=edit&id=${user.id}">Edit</a>--%>
    <%--                    <a href="/Users?action=delete&id=${user.id}">Delete</a>--%>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/Users?action=delete" method="post">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Bạn thực sự muốn xóa? </h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <input name="id" id="userId" hidden>
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
        document.getElementById("userId").value=id;
    }
</script>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Phong Vu
  Date: 11/17/2021
  Time: 10:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="d" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <table border="1" class="table table-warning table-striped table-hover">
        <tr>
            <th>Full Name</th>
            <th>Introduction</th>
            <th>User Name</th>
            <th>Pass Word</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <d:forEach items="${userList}" var="user">
            <tr>
                <td><a href="/login?action=view&id=${user.id}">${user.fullName}</a></td>
                <td>${user.introduction}</td>
                <td>${user.userName}</td>
                <td>${user.passWord}</td>
                <td><a href="/login?action=edit&id=${user.id}">Edit</a></td>
                <td><a href="/login?action=delete&id=${user.id}">Delete</a></td>
            </tr>

        </d:forEach>
    </table>
    <a href="index.jsp"><input type="submit" value="Logout"></a>
</div>
</body>
</html>

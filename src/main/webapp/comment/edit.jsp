<%--
  Created by IntelliJ IDEA.
  User: Phong Vu
  Date: 11/18/2021
  Time: 11:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/comment?action=edit&id=${comment.id}" method="post">
    <p>${comment.getUser().fullName}</p>
    <input type="text" name="content" value="${comment.content}">
    <input type="submit" value="Save">
</form>
<form action="/login?action=login" method="post">
    <input type="submit" value="Back Home">
</form>

</body>
</html>

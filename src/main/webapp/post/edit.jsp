<%--
  Created by IntelliJ IDEA.
  User: Phong Vu
  Date: 11/17/2021
  Time: 11:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Post</title>
</head>
<body>
<form action="/post?action=edit&id=${post.id}" method="post">
    <p>${post.getUser().fullName}</p>
    <input type="text" name="tittle" value="${post.tittle}">
    <input type="text" name="content" value="${post.content}">
    <input type="text" name="image" id="image" placeholder="new image url" value="${post.image}">
    <input type="submit" value="Save">
    <p><c:if test="${message!=null}">
        <span>${message}</span>
    </c:if></p>
    <a href="/login?action=homePageUser"><input type="submit" value="Back Home"></a>
</form>

</body>
</html>

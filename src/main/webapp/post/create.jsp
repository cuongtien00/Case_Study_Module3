<%--
  Created by IntelliJ IDEA.
  User: Phong Vu
  Date: 11/18/2021
  Time: 3:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/post?action=create&id=${user.id}" method="post">--%>
                    <td><input type="text" placeholder="title" name="tittle" id="tittle"></td>
                    <td><textarea name="content" id="content" cols="30" rows="10" placeholder="what are you thinking?"></textarea></td>
                    <td><textarea name="image" id="image" cols="30" rows="10" placeholder="image url?"></textarea></td>
                   <input type="submit" value="post">
                </form>
<%--        <c:if test="${user.id == post.getUser().id}">--%>
            <div id="post">
                <p>${post.tittle}</p>
                <p>${post.content}</p>
                <p>${post.id}</p>
                <p>${user.id}</p>
                <div id="img"><img src="${post.image}" alt=""></div>
                <a href="/post?action=edit&id=${post.id}">Edit</a>
                <a href="/post?action=delete&id=${post.id}">Delete</a>
            </div>
<%--        </c:if>--%>
</body>
</html>

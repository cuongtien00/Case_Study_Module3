<%--
  Created by IntelliJ IDEA.
  User: Phong Vu
  Date: 11/16/2021
  Time: 3:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>
        CSS Website Layout
    </title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="css.css">
</head>

<body>
<p>${user.fullName}</p>
<p>${user.introduction}</p>
<a href="/post?action=create&id=${user.id}"><input type="submit">create form</a>
<div align="center">
    <table border="1" class="table table-warning table-striped table-hover">
        <tr>
            <th><a href="/books?action=sort">Full Name</a></th>
            <td><a href="/login?action=view&id=${user.id}">${user.fullName}</a></td>


        </tr>
            <tr>
                <th>Introduction</th>
                <td>${user.introduction}</td>

            </tr>
        <tr>
            <th>Edit</th>
            <td><a href="/login?action=edit&id=${user.id}">Edit</a></td>
        </tr>
<%--        <tr>--%>
<%--            <form action="/post?action=create&id=${user.id}" method="post">--%>
<%--                <td><input type="text" placeholder="title" name="tittle" id="tittle"></td>--%>
<%--                <td><textarea name="content" id="content" cols="30" rows="10" placeholder="what are you thinking?"></textarea></td>--%>
<%--                <td><textarea name="image" id="image" cols="30" rows="10" placeholder="image url?"></textarea></td>--%>
<%--               <input type="submit" value="post">--%>
<%--            </form>--%>

<%--        </tr>--%>
    </table>
<fieldset>
    <legend>facebook</legend>
    <fieldset>
        <legend>Post</legend>
        <div id="post">
            <c:forEach items="${postList}" var="post">
                <c:if test="${user.id == post.getUser().id}">
                    <%--                        <p>${"bai viet cua: "+user.fullName}</p>--%>
                    <p>${post.tittle}</p>
                    <p>${post.content}</p>
                    <div style="width: 200px" id="img"><img src="${post.image}" alt="" width="100%"></div>
                    <a href="/post?action=edit&id=${post.id}">Edit</a>
                    <a href="/post?action=delete&id=${post.id}">Delete</a>
                    <%
                        request.setAttribute("likePostList",likePostService.findAllByPostId( ));%>

<%--                    <c:if test="${likePostList.size()!=0}">--%>
<%--                        <c:set var="count" value="${0}">--%>
<%--                            <c:forEach items="${likePostList}" var="likePost">--%>
<%--                                <c:if test="${post.id==likePost.getPost().id}">--%>
<%--                                    <span>${count+=1} </span>--%>
<%--                                </c:if>--%>
<%--                            </c:forEach>--%>
<%--                        </c:set>--%>
<%--                    </c:if>--%>
                    <div  _ngcontent-aey-c24="" class="users-thumb-list cg ng-star-inserted"><!----><a _ngcontent-aey-c24="" class="margin-left-icon ng-star-inserted" placement="top" aria-describedby="tooltip-2"><img _ngcontent-aey-c24="" class="font-size-image-icon" src="https://tim.codegym.vn/assets/images/likes-type/icon-haha.svg " style="width: 50px;height: 20px"></a><!----><a _ngcontent-aey-c24="" class="margin-left-icon ng-star-inserted" placement="top" aria-describedby="tooltip-3"><img _ngcontent-aey-c24="" class="font-size-image-icon" src="https://tim.codegym.vn/assets/images/likes-type/icon-like.svg" style="width: 50px;height: 20px"></a><!----><span _ngcontent-aey-c24=""><strong _ngcontent-aey-c24=""></strong><a _ngcontent-aey-c24="" class="cursor" placement="top" aria-describedby="tooltip-0"> 12 </a><span _ngcontent-aey-c24="" class="cursor" placement="top" aria-describedby="tooltip-1"> người khác đã thích </span></span><!----></div>

                    <form action="/likePost?action=create&id=${post.id}" method="post">
                        <input type="submit" value="like">
                    </form>
<%--                    <a href="">Like</a>--%>
<%--                    <a href="/likePost?action=delete&id=">UnLike</a>--%>
                    <fieldset>
                        <legend>
                            Comment
                        </legend>
<%--                        <select name="comment" id="comment" multiple>--%>
                            <c:forEach items="${commentList}" var="comment">
                                <c:if test="${post.id==comment.getPost().id}">
                                    <p>${comment.getUser().fullName}</p>
                                    <p>${comment.content}</p>
                                    <a href="/comment?action=edit&id=${comment.id}">Edit</a>
                                    <a href="/comment?action=delete&id=${comment.id}">Delete</a>
                                </c:if>
                            </c:forEach>
<%--                        </select>--%>
                       <div id="writeComment" style="width: 300px">
                           <form action="/comment?action=create&id=${post.id}" method="post">
                               <input placeholder="your comment" type="text" name="content" id="content" style="background-color: pink">
                               <input type="submit" value="Comment" style="background-color: black">
                           </form>
                       </div>


                    </fieldset>
                </c:if>
            </c:forEach>




        </div>

    </fieldset>
</fieldset>



    <a href="index.jsp"><input type="submit" value="Logout"></a>
</div>

</body>
</html>
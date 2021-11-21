<%--
  Created by IntelliJ IDEA.
  User: Phong Vu
  Date: 11/21/2021
  Time: 5:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<img width="25px" src="https://scontent.fhan2-4.fna.fbcdn.net/v/t1.6435-1/p240x240/176721927_2777154399203806_9221647697328955255_n.jpg?_nc_cat=105&ccb=1-5&_nc_sid=7206a8&_nc_ohc=OYyzDyZidQQAX-p2JnO&tn=DiG6r9MpeiF0nqDv&_nc_ht=scontent.fhan2-4.fna&oh=9b79c0cf950eb09d44ff6704bf1a8214&oe=61A91F98" alt="">--%>

<!DOCTYPE html>
<html>
<head>
    <title>
        Facebook
    </title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
          integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link rel="stylesheet" href="homePageUser.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        a {
            text-decoration: none;
            color: white
        }

    </style>
</head>

<body>

<div id="header" class="container-fluid"
     style="width: 100%;background-color:#1c1e21;display:flex;position: fixed;align-items: center">
    <div style="display: flex;align-items: center;width: 509.6px;">
        <div id="logo">
            <img style="width: 50px;"
                 src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/Facebook_f_logo_%282019%29.svg/768px-Facebook_f_logo_%282019%29.svg.png"
                 alt="">
        </div>
        <div class="input-group mb-3" style="width: 250px;padding-top: 15px;">
            <form action="/login?action=search" method="post">
                <input style="border-radius: 100px;background-color:#3a3b3c;margin-left: 10px;" name="search" id="search" type="text"
                       class="form-control"
                       placeholder="Search?">
            </form>

        </div>
    </div>
    <div style="display: flex;align-items: center;width: 500px;">
        <div id="menu">
            <a id="home" href="" style="text-align: center">
                <i class="fas fa-home" style="font-size: 28px"></i>
            </a>
            <a id="watch" href="" style="text-align: center">
                <i class="fab fa-youtube" style="font-size: 28px;margin-left: 72px"></i>
            </a>
            <a id="market" href="" style="text-align: center">
                <i class="fas fa-store" style="font-size: 28px;margin-left: 72px"></i>
            </a>
            <a id="group" href="" style="text-align: center">
                <i class="fas fa-users" style="font-size: 28px;margin-left: 72px"></i>
            </a>
            <a id="gaming" href="" style="text-align: center">
                <i class="fab fa-fantasy-flight-games" style="font-size: 28px;margin-left: 72px"></i>
            </a>
        </div>
    </div>

    <div class="right-nav" style="margin-left: 200px;">
        <a href="/login?action=view&id=${user.id}">${user.fullName}</a>
        <a href="/login?action=logout" style="margin-left: 30px;">Logout</a>
    </div>
</div>
<div class="mid" style="display: flex;">
    <div id="left-sidebar" style="width: 360px;
    background-color:#242526;margin-top: 69px;position: fixed;
    height: 100%;
    ">
    </div>
    <div id="right-sidebar" style="width: 1159.2px;
    background-color:#18191a;margin-left: 360px;">
        <div  class="container-fluid" id="result" style="margin-top: 69px">
            <c:forEach items="${resultSearchList}" var="user">
                <div style="background-color: #242526;border-radius: 10px;display: flex;color: white;width: 680px;margin-left: 310px;height: 115.97px;
    margin-top: 100px;">
                    <div id="content" style="width: 600px;">
                        <p style="font-size: 20px;margin-left: 30px;margin-bottom: 3px">${user.fullName}</p>
                        <p style="font-size: 15px;margin-left: 30px;">Introduction: ${user.introduction}</p>
                    </div>
                    <div id="button" style="margin-top: 38.39px;margin-right: 10px;">
                        <c:forEach items="${relationshipList}" var="friend">
                            <c:if test="${user.id==friend.getSendUser().id&&friend.status==0}">
                                <a href="/relationship?action=accept&id=${friend.id}">
                                    <button type="button" class="btn btn-primary">Request</button>
                                </a>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
                <hr>
                -
                </hr>
            </c:forEach>
        </div>
    </div>
</div>

<%--<div class="footer">--%>
<%--    <footer class="bg-light text-center text-white">--%>
<%--        <!-- Grid container -->--%>
<%--        <div class="container p-4 pb-0" style="background-color: #272d35">--%>
<%--            <!-- Section: Social media -->--%>
<%--            <section class="mb-4" style="background-color: #272d35">--%>
<%--                <!-- Facebook -->--%>
<%--                <a--%>
<%--                        class="btn btn-primary btn-floating m-1"--%>
<%--                        style="background-color: #3b5998;"--%>
<%--                        href="#!"--%>
<%--                        role="button"--%>
<%--                ><i class="fab fa-facebook-f"></i--%>
<%--                ></a>--%>

<%--                <!-- Twitter -->--%>
<%--                <a--%>
<%--                        class="btn btn-primary btn-floating m-1"--%>
<%--                        style="background-color: #55acee;"--%>
<%--                        href="#!"--%>
<%--                        role="button"--%>
<%--                ><i class="fab fa-twitter"></i--%>
<%--                ></a>--%>

<%--                <!-- Google -->--%>
<%--                <a--%>
<%--                        class="btn btn-primary btn-floating m-1"--%>
<%--                        style="background-color: #dd4b39;"--%>
<%--                        href="#!"--%>
<%--                        role="button"--%>
<%--                ><i class="fab fa-google"></i--%>
<%--                ></a>--%>

<%--                <!-- Instagram -->--%>
<%--                <a--%>
<%--                        class="btn btn-primary btn-floating m-1"--%>
<%--                        style="background-color: #ac2bac;"--%>
<%--                        href="#!"--%>
<%--                        role="button"--%>
<%--                ><i class="fab fa-instagram"></i--%>
<%--                ></a>--%>

<%--                <!-- Linkedin -->--%>
<%--                <a--%>
<%--                        class="btn btn-primary btn-floating m-1"--%>
<%--                        style="background-color: #0082ca;"--%>
<%--                        href="#!"--%>
<%--                        role="button"--%>
<%--                ><i class="fab fa-linkedin-in"></i--%>
<%--                ></a>--%>
<%--                <!-- Github -->--%>
<%--                <a--%>
<%--                        class="btn btn-primary btn-floating m-1"--%>
<%--                        style="background-color: #333333;"--%>
<%--                        href="#!"--%>
<%--                        role="button"--%>
<%--                ><i class="fab fa-github"></i--%>
<%--                ></a>--%>
<%--            </section>--%>
<%--            <!-- Section: Social media -->--%>
<%--        </div>--%>
<%--        <!-- Grid container -->--%>

<%--        <!-- Copyright -->--%>
<%--        <div class="text-center p-3" style="background-color: #272d35">--%>
<%--            © 2021 MADE BY:--%>
<%--            <a class="text-white" href="https://www.facebook.com/nhathagigido/">CuongTien</a>--%>
<%--        </div>--%>
<%--        <!-- Copyright -->--%>
<%--    </footer>--%>
<%--</div>--%>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
        integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
        integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
        crossorigin="anonymous"></script>
</body>
</html>

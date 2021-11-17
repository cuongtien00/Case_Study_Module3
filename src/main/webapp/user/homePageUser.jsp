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
<div id="nav">
    <div id="logo">
        <a href="https://www.facebook.com/">
            <i class="fab fa-facebook"></i>
        </a>
        <input id='search' placeholder="Bạn đang tìm gì?" type="text"  style="border-radius: 50px";>

    </div>
    <div id="menu">
        <a id="home" href="">
            <i class="fas fa-home"></i>
        </a>
        <a id="watch" href="">
            <i class="fab fa-youtube"></i>
        </a>
        <a id="market" href="">
            <i class="fas fa-store"></i>
        </a>
        <a id="group" href="">
            <i class="fas fa-users"></i>
        </a>
        <a id="gaming" href="">
            <i class="fab fa-fantasy-flight-games"></i>
        </a>
    </div>
    <div id="diff">
        <a id="img" href="">
            <img width="25px" src="https://scontent.fhan2-4.fna.fbcdn.net/v/t1.6435-1/p240x240/176721927_2777154399203806_9221647697328955255_n.jpg?_nc_cat=105&ccb=1-5&_nc_sid=7206a8&_nc_ohc=OYyzDyZidQQAX-p2JnO&tn=DiG6r9MpeiF0nqDv&_nc_ht=scontent.fhan2-4.fna&oh=9b79c0cf950eb09d44ff6704bf1a8214&oe=61A91F98" alt="">
        </a>
        <span id="name">cường Tiến</span>
        <a id="menu2" href="">
            <i class="fas fa-ellipsis-h"></i>
        </a>
        <a id="mess" href="">
            <i class="fab fa-facebook-messenger"></i>
        </a>
        <a id="notification" href="">
            <i class="fas fa-bell"></i>
        </a>
        <a id="account" href="">
            <i class="fas fa-caret-down"></i>
        </a>
    </div>

</div>
<div id="content">

</div>
</body>
</html>
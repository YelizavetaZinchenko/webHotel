<%@ page contentType="text/html;charset=cp1251" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <style><%@include file="/WEB-INF/css/main.css"%></style>
    <meta charset="UTF-8">
    <title>TILL MIDNIGHT</title>
    <link href="https://fonts.googleapis.com/css2?family=Anton&family=Open+Sans&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css.main.css">
</head>
<body>
<header class="header" id="header">
    <div class="container">
        <div class="nav">
            <a href="TILL MIDNIGHT">
                <style>
                    body {
                        background: #c7b39b url(images/Inkedb_LI.jpg) no-repeat;
                        color: #fff;
                        -moz-background-size: 100%;
                        -webkit-background-size: 100%;
                        -o-background-size: 100%;
                        background-size: 100%;
                    }
                </style>
                <ul class="menu">
                    <li>
                        <a href="index.jsp">
                            Home
                        </a>
                    </li>
                    <li>
                        <a href="RoomServlet">
                            To book
                        </a>
                    </li>
                    <li>
                        <a href="about.jsp">
                            About
                        </a>
                    </li>
                    <li>
                        <a href="contacts.jsp">
                            Contacts
                        </a>
                    </li>
                </ul>
                <c:choose>
                    <c:when test="${someName ne null}">
                        <ul>
                            <a class="btn sign-up" href="LogOutServlet">Log Out</a>
                        </ul>
                        <ul>
                            <a class="btn log-in" href="ProfileServlet">Profile</a>
                    </c:when>
                    <c:otherwise>
                        </ul>
                        <ul>
                            <a class="btn sign-up" href="signin.jsp">sign up</a>
                        </ul>
                        <ul>
                            <a class="btn log-in" href="login.jsp">log in</a>
                        </ul>
                    </c:otherwise>
                </c:choose>
        </div>
    </div>

    <section class="about" id="about">
        <div class="container">
            <h2>About the hotel</h2>
            <div class="description">
                <div class="desc-left">
                    <h3>Reservation department</h3>
                    <a class="tel" href="tel:+380663784958">
                        +38066-378-49-58
                    </a><br>
                    <br>
                    <a class="tel" href="tel:+380663784958">
                        +38073-456-38-14
                    </a><br>
                    <br>
                    <a class="tel" href="tel:+380663784958">
                        +38068-285-13-90
                    </a><br>
                    <br>
                    <a class="tel" href="email: zinchenkoelizabeth@gmail.com">
                        zinchenkoelizabeth@gmail.com
                    </a><br>
                    <br><a>
                    126341, BLACKWOOD AVE, KHARKIV, UKRAINE
                </a><br>
                    <br>
                    <br><br>
                </div>
                <div class="desc-right">
                    <img alt="Event photo 1" src="images/Inkedb72bf1e73b45299651407735f6f8a8e3_LI.jpg">
                </div>
            </div>
</header>
<footer class="footer" id="footer">
    <div class="container">
        <div class="footer-text">
            <p>
                ©2021 ZinchenkoElizabeth
            </p>
            <p1>
                All right reserved.
            </p1>
        </div>
    </div>
</footer>
</body>
</html>
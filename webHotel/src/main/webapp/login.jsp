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
    <div class="container">

        <div class="nav">
            <a href="TILL MIDNIGHT">
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
        </div>
        <form action="LoginServlet" class="form" method="post">
            <div class="gall">
                <img alt="Eventy" src="images/picture.jpg">
            </div>
            <input class="input" name="Email" placeholder="E-mail" type="email">
            <input class="input" name="Password" placeholder="Password" type="password">
            <button class="btny" type="submit">Log in</button>
        </form>
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
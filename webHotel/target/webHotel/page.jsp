<%@ page contentType="text/html;charset=cp1251" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Burning Man</title>
    <link href="https://fonts.googleapis.com/css2?family=Anton&family=Open+Sans&display=swap" rel="stylesheet">
    <link rel="icon" href="i,/favicon.png" type="image/x-icon">
    <link rel="shortcut icon" href="i,/favicon.png" type="image/x-icon">
    <link rel="stylesheet" href="css.main.css">
</head>
<body>
<header id="header" class="header">
    <style>
        body {
            background: #c7b39b url(i,/Inkedb_LI.jpg) no-repeat; /* Цвет фона и путь к файлу */
            color: #fff; /* Цвет текста */
            -moz-background-size: 100%; /* Firefox 3.6+ */
            -webkit-background-size: 100%; /* Safari 3.1+ и Chrome 4.0+ */
            -o-background-size: 100%; /* Opera 9.6+ */
            background-size: 100%; /* Современные браузеры */
        }
    </style>
    <div class="container">

        <div class="nav">
            <img src="i,/logo.svg" alt="Burning Man" class="logo">
            <ul class="menu">
                <li>
                    <a href="proj.html">
                        Home
                    </a>
                </li>
                <li>
                    <a href="book.html">
                        To book
                    </a>
                </li>
                <li>
                    <a href="about.html">
                        About
                    </a>
                </li>
                <li>
                    <a href="contact.html">
                        Contacts
                    </a>
                </li>
            </ul>
            <ul>
                <a href="sign.html" class="btn sign-up">sign up</a>
<!--            <button  class = "btn sign-up">sign up</button>-->
            </ul>
            <ul>
                <a href="log.html" class="btn log-in">log in</a>
<!--            <button class = "btn log-in">log in</button>-->
                </ul>
        </div>
        <div class="offer">
            <p>It's cosy here. Always.</p>
            <h1>
                TILL midnight
            </h1>
            <a href="book.html" class="btn">Book the room</a>
        </div>
    </div>
</header>
<footer id="footer" class="footer">
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
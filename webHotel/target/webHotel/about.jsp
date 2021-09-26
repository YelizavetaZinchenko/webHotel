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
<header id="header" class="header">
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
                            <a href="LogOutServlet" class="btn sign-up">Log Out</a>
                        </ul>
                        <ul>
                            <a href="ProfileServlet" class="btn log-in">Profile</a>
                    </c:when>
                    <c:otherwise>
                        </ul>
                        <ul>
                            <a href="signin.jsp" class="btn sign-up">sign up</a>
                        </ul>
                        <ul>
                            <a href="login.jsp" class="btn log-in">log in</a>
                        </ul>
                    </c:otherwise>
                </c:choose>
        </div>
    </div>
    <section id="about" class="about">
        <div class="container">
            <h2>About the hotel</h2>
            <div class="description">
                <div class="desc-left">
                    <h3>Architecture & Atmosphere</h3>
                    <p>
                        Hotel "Salyut" was built by architect Abraham Miletsky in 1984. Thanks to an unusual
                        architectural solution, the hotel building has become one of the most unusual buildings of the
                        past era.The staff of the Arkady hotel complex is a friendly team of professionals that creates
                        an atmosphere of real relaxation.After examining the hotel's capabilities and infrastructure,
                        the European hotel certification organization awarded it a 5-star comfort category.
                    </p>
                </div>
                <div class="desc-right">
                    <h3>
                        Our advantages</h3>
                    <p>
                        The hotel will provide all services necessary for leisure and business: Room Service, high-speed
                        WiFi, business center, transport service, parking, luggage storage, laundry, dry cleaning and
                        beauty salon.The administration of the Bless hotel cares about preserving the image of the hotel
                        as a worthy and cultural place for recreation.
                        The main principle of the Bless hotel is an individual approach to each guest!
                        Room (s) at Bless Hotel are booked on a prepayment basis.
                    </p>
                </div>
            </div>
            <div class="gallery">
                <img src="images/ww.jpg" alt="Event photo 1">
                <img src="images/rr.jpg" alt="Event photo 2">
                <img src="images/dd.jpg" alt="Event photo 3">
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
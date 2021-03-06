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
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="res"/>
<header class="header" id="header">
              <nav id="languageHeader">
                          <a href="LocalizationServlet?language=en"><img class="flag" src="images/aaaaaa.png"></a>
                          <span class="stick"></span>
                          <a href="LocalizationServlet?language=ru" ><img class="flag" src="images/ddddddd.png"></a>
                        </nav>
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
                                                <label><fmt:message key="home"/></label>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="RoomServlet">
                                                <label><fmt:message key="To_book"/></label>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="about.jsp">
                                            <label><fmt:message key="About"/></label>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="contacts.jsp">
                                            <label><fmt:message key="Contacts"/></label>
                                            </a>
                                        </li>
                                    </ul>
                                    <c:choose>
                                        <c:when test="${someName ne null}">
                                            <ul>
                                                <a class="btn sign-up" href="LogOutServlet"><label><fmt:message key="Log_out"/></label></a>
                                            </ul>
                                            <ul>
                                                <a class="btn log-in" href="ProfileServlet"><label><fmt:message key="Profile"/></label></a>
                                        </c:when>
                                        <c:otherwise>
                                            </ul>
                                            <ul>
                                                <a class="btn sign-up" href="signin.jsp"><label><fmt:message key="sign_up"/></label></a>
                                            </ul>
                                            <ul>
                                                <a class="btn log-in" href="login.jsp"><label><fmt:message key="log_in"/></label></a>
                                            </ul>
                    </c:otherwise>
                </c:choose>
        </div>
    </div>

    <section class="about" id="about">
        <div class="container">
            <h2><label><fmt:message key="About_the_hotel"/></label></h2>
            <div class="description">
                <div class="desc-left">
                    <h3><label><fmt:message key="Reservation_department"/></label></h3>
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
                ??2021 ZinchenkoElizabeth
            </p>
            <p1>
                All right reserved.
            </p1>
        </div>
    </div>
</footer>
</body>
</html>
<%@ page contentType="text/html;charset=cp1251" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
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
        </div>
        <tag:customLoginTag/>
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
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
        <div class="book">
            <div class="book-form">
                <div class="form-item">

                    <c:choose>
                        <c:when test="${someID ne null}">
                            <a href="#win5" type="submit" class="btn">Make an application</a>
                            <br/>
                        </c:when>
                        <c:otherwise>
                            <h>You can not make an application. Please log in.</h>
                            <br/>
                        </c:otherwise>
                    </c:choose>


                    <!-- Модальное окно №5 -->
                    <form action="ApplicationServlet" method="post">
                        <a href="#x" class="overlay" id="win5"></a>
                        <div class="popup">
                            <input class="input" type="number" name="price" placeholder="Price">
                            <input class="input" type="number" name="amountOfSeats" placeholder="Amount of the seats">
                            <input class="input" type="text" name="classOfRoom" placeholder="Class of the room">
                            <input class="input" type="text" name="statusOfRoom" placeholder="Status of the room">
                            <button a href="#win6" class="btny" type="submit">Make an application</button>
                        </div>
                        <a class="close" title="Закрыть" href="#close"></a>
                    </form>

                </div>
            </div>
        </div>

        <form action="RoomServlet" method="post">
            <p class="sortedByText"><label>Sort by:</label>
                <select class="selectSort" name="Sort">
                    <option class="sortText"><label>-</label></option>
                    <option class="sortText"><label>Price<label></option>
                    <option class="sortText"><label>Amount Of Seats</label></option>
                    <option class="sortText"><label>Class Of Room</label></option>
                    <option class="sortText"><label>Status Of Room</label></option>
                </select>
            </p>
            <button class="confirmSort" type="submit">Find</button>
        </form>

        <section class="rooms sec-width" id="rooms">
            <div class="title">
                <h2>rooms</h2>
                <div class="rooms-container">
                    <!-- single room -->


                    <c:choose>
                        <c:when test="${roomList.size() ne 0}">
                            <c:forEach var="i" begin="0" end="${roomList.size() - 1}">
                                <c:choose>
                                    <c:when test="${roomList.get(i).getStatusOfRoom() ne 'booked'}">
                                        <article class="room">
                                            <div class="room-image">
                                                <img src="images/ww.jpg" alt="room image">
                                            </div>
                                            <div class="room-text">
                                                <h3>${roomList.get(i).getClassOfRoom()}</h3>
                                                <ul>
                                                    <li>
                                                        <i class="fas fa-arrow-alt-circle-right"></i>
                                                        Amount Of Seats: ${roomList.get(i).getAmountOfSeats()}
                                                    </li>


                                                    <li>
                                                        <i class="fas fa-arrow-alt-circle-right"></i>
                                                        Status Of Room: ${roomList.get(i).getStatusOfRoom()}
                                                    </li>


                                                    <li>
                                                        <i class="fas fa-arrow-alt-circle-right"></i>
                                                        Feeling of relaxation and comfort.
                                                    </li>
                                                </ul>
                                                <p>Spacious living room suitable for comfortable rest and business
                                                    meetings.</p>
                                                <p>The bathroom is equipped with a shower cabin, a sink, and modern
                                                    fixtures. Installed a multi-level system of coal cleaning and air
                                                    circulation.Decor elements recreate the atmosphere.</p>
                                                <p class="rate">
                                                    <span>Price: ${roomList.get(i).getPrice()}</span>
                                                </p>
                                                <c:choose>
                                                    <c:when test="${someID ne null}">
                                                        <form action="ProfileServlet" method="post">
                                                            <button type="submit" name="roomId"
                                                                    value="${roomList.get(i).getId()}" class="btn">book
                                                                now
                                                            </button>
                                                            <br/>
                                                        </form>
                                                    </c:when>
                                                </c:choose>
                                            </div>
                                        </article>
                                    </c:when>
                                </c:choose>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <div class="itemsNotFound">
                                <h0>Items not found :(</h0>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </section>
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
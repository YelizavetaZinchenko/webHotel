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
        <div class="book">
            <div class="book-form">
                <div class="form-item">

                    <c:choose>
                        <c:when test="${someID ne null}">
                            <a href="#win5" type="submit" class="btn"><label><fmt:message key="Make_an_application"/></label></a>
                            <br/>
                        </c:when>
                        <c:otherwise>
                            <h><label><fmt:message key="You_can_not_make_an_application"/></label></h>
                            <br/>
                        </c:otherwise>
                    </c:choose>

                    <form action="ApplicationServlet" method="post">
                        <a href="#x" class="overlay" id="win5"></a>
                        <div class="popup">

                            <fmt:message key="price" var="price"/>
                            <input class="input" type = "number" name = "price" placeholder="${price}">

                            <fmt:message key="amountOfSeats" var="amountOfSeats"/>
                            <input class="input" type = "number" name = "amountOfSeats" placeholder="${amountOfSeats}">

                             <fmt:message key="classOfRoom" var="classOfRoom"/>
                            <input class="input" type = "text" name = "classOfRoom" placeholder="${classOfRoom}">

                            <fmt:message key="statusOfRoom" var="statusOfRoom"/>
                            <input class="input" type = "text" name = "statusOfRoom" placeholder="${statusOfRoom}">
                            <button a href="#win6" class="btny" type="submit"><label><fmt:message key="Make_an_application"/></label></button>
                        </div>
                        <a class="close" title="Закрыть" href="#close"></a>
                    </form>

                </div>
            </div>
        </div>
        <form action="RoomServlet" method="post">
            <p class="sortedByText"><label><fmt:message key="Sort_by"/></label>
                <select class="selectSort" name="Sort">
                    <option class="sortText"><label>-</label></option>
                    <option class="sortText"><label><fmt:message key="price"/><label></option>
                    <option class="sortText"><label><fmt:message key="amountOfSeats"/></label></option>
                    <option class="sortText"><label><fmt:message key="classOfRoom"/></label></option>
                    <option class="sortText"><label><fmt:message key="statusOfRoom"/></label></option>
                </select>
            </p>
            <button class="confirmSort" type="submit"><label><fmt:message key="Find"/></label></button>
        </form>

        <section class="rooms sec-width" id="rooms">
            <div class="title">
                <h2><label><fmt:message key="rooms"/></label></h2>
                <div class="rooms-container">
                    <!-- single room -->


                    <c:choose>
                        <c:when test="${roomList.size() ne 0}">
                            <c:forEach var = "i" begin="0" end="${Amount - 1}">
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
                            <div class="Ididnotfindanything">
                                <h0>Sorry. All the rooms are taken.</h0>
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
    <div class="containerPagination">
            <c:if test="${pageList.size() ne 0}">
                 <div class="pagination">
                     <c:forEach var="pages" items="${pageList}">
                         <a href="RoomServlet?Amount=${Amount}&page=${pages}">${pages}</a>
                     </c:forEach>
                 </div>
            </c:if>
    </div>
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
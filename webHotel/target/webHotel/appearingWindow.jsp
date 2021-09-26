<%@ page contentType="text/html;charset=cp1251" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <style><%@include file="/WEB-INF/css/main.css"%></style>
    <meta charset="UTF-8">
    <title>Burning Man</title>
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
                    background: #c7b39b url(images/Inkedb_LI.jpg) no-repeat; /* Цвет фона и путь к файлу */
                    color: #fff; /* Цвет текста */
                    -moz-background-size: 100%; /* Firefox 3.6+ */
                    -webkit-background-size: 100%; /* Safari 3.1+ и Chrome 4.0+ */
                    -o-background-size: 100%; /* Opera 9.6+ */
                    background-size: 100%; /* Современные браузеры */
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

  <!-- Вызов окна через миниатюру изображения -->
  <a href="#win5"><img title="" src="img/realism_lrg.jpg" width="150" height="150" alt="" /></a>
  <!-- Модальное окно №5 -->
          <a href="#x" class="overlay" id="win5"></a>
          <div class="popup">
  <img class="is-image" src="ваша-картинка.jpg" alt="" />
  <a class="close" title="Закрыть" href="#close"></a>
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
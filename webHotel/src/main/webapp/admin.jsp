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
        <form class="form" action="AdminServlet" method="post">

            <div class="adminActions">
                <button id="userListButton" class="listOfUsersButton" type="submit"><label>
                    <fmt:message key="user_list"/>
                </label></button>
                <table id="tableOfUsers_Admin">
                    <tr>
                        <th>Id</th>
                        <th>Email</th>
                        <th>Name</th>
                        <th>Admin</th>
                        <th>Password</th>
                    </tr>
                    <c:forEach var="user" items="${userList}">
                        <tr>
                            <td>${user.getId()}</td>
                            <td>${user.email}</td>
                            <td>${user.name}</td>
                            <td>${user.admin}</td>
                            <td>${user.password}</td>
                        </tr>
                    </c:forEach>
                </table>

                document.getElementById('userListButton').onclick = function() {
                document.getElementById('changeUserContainer').style.display = "none";
                document.getElementById('hiddenBlock').style.display = "none";
                document.getElementById('tableOfUsers_Admin').style.display = "block";
                document.getElementById('bookListTable').style.display = "none";
                document.getElementById('deleteBookContainer').style.display = "none";
                document.getElementById('changeBookContainer').style.display = "none";
                document.getElementById('insertBookContainer').style.display = "none";
                }


        </form>
        </c:if>
    </div>

    </div>
    </div>
    </form>
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
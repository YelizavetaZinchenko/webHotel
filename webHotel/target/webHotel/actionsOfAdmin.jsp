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
    <div class="adminActions">
        <button id="userListButton" class="listOfUsersButton" type="submit"><label><fmt:message key="User_List"/></label></button>
        <button id="roomListButton" class="listOfRoomButton" type="submit"><label><fmt:message key="Room_List"/></label</button>
        <button id="applicationListButton" class="listOfApplicationButton" type="submit"><label><fmt:message key="Application_List"/></label></button>
        <button id="ConfirmationListButton" class="listOfConfirmationButton" type="submit"><label><fmt:message key="Confirmation_of_admin"/></label></button>
        </button>

        <table id="tableOfUsers">
            <tr>
                <th><label><fmt:message key="Id"/></label></th>
                <th><label><fmt:message key="Email"/></label></th>
                <th><label><fmt:message key="Name"/></label></th>
                <th><label><fmt:message key="Admin"/></label></th>
            </tr>
            <c:forEach var="user" items="${userList}">
                <tr>
                    <td>${user.getId()}</td>
                    <td>${user.getEmail()}</td>
                    <td>${user.getName()}</td>
                    <td>${user.getAdmin()}</td>
                </tr>
            </c:forEach>
        </table>

        <table id="roomListTable">
            <tr>
                <th><label><fmt:message key="Id"/></label></th>
                <th><label><fmt:message key="Price"/></label></th>
                <th><label><fmt:message key="AmountOfSeats"/></label></th>
                <th><label><fmt:message key="StatusOfRoom"/></label></th>
                <th><label><fmt:message key="ClassOfRoom"/></label></th>
            </tr>
            <c:forEach var="room" items="${roomList}">
                <tr>
                    <td>${room.getId()}</td>
                    <td>${room.getPrice()}</td>
                    <td>${room.getAmountOfSeats()}</td>
                    <td>${room.getStatusOfRoom()}</td>
                    <td>${room.getClassOfRoom()}</td>
                </tr>
            </c:forEach>
        </table>

        <table id="applicationListTable">
            <tr>
               <th><label><fmt:message key="Id"/></label></th>
               <th><label><fmt:message key="User_id"/></label></th>
               <th><label><fmt:message key="Price"/></label></th>
               <th><label><fmt:message key="AmountOfSeats"/></label></th>
               <th><label><fmt:message key="StatusOfRoom"/></label></th>
               <th><label><fmt:message key="ClassOfRoom"/></label></th>
            </tr>
            <c:forEach var="application" items="${applicationList}">
                <tr>
                    <td>${application.getId()}</td>
                    <td>${application.getUser_id()}</td>
                    <td>${application.getPrice()}</td>
                    <td>${application.getAmountOfSeats()}</td>
                    <td>${application.getStatusOfRoom()}</td>
                    <td>${application.getClassOfRoom()}</td>
                </tr>
            </c:forEach>
        </table>

        <div id="changeUserContainer">
            <form action="ConfirmationOfAdminServlet" method="post">
                <div class="dws-input">
                    <input type="number" name="user_admin_id" <label><fmt:message key="User_id"/></label>
                    <input type="number" name="room_admin_id" <label><fmt:message key="Room_id"/></label>
                </div>
                <button class="btn confirmation" type="submit"><label><fmt:message key="confirm"/></label></button>
            </form>
        </div>

    </div>

</header>
<script>
    document.getElementById('userListButton').onclick = function () {
        document.getElementById('tableOfUsers').style.display = "block";
        document.getElementById('roomListTable').style.display = "none";
        document.getElementById('applicationListTable').style.display = "none";
        document.getElementById('changeUserContainer').style.display = "none";
    }
    document.getElementById('roomListButton').onclick = function () {
        document.getElementById('roomListTable').style.display = "block";
        document.getElementById('tableOfUsers').style.display = "none";
        document.getElementById('applicationListTable').style.display = "none";
        document.getElementById('changeUserContainer').style.display = "none";
    }
    document.getElementById('applicationListButton').onclick = function () {
        document.getElementById('applicationListTable').style.display = "block";
        document.getElementById('tableOfUsers').style.display = "none";
        document.getElementById('roomListTable').style.display = "none";
        document.getElementById('changeUserContainer').style.display = "none";
    }
    document.getElementById('ConfirmationListButton').onclick = function () {
        document.getElementById('changeUserContainer').style.display = "block";
        document.getElementById('tableOfUsers').style.display = "none";
        document.getElementById('roomListTable').style.display = "none";
        document.getElementById('applicationListTable').style.display = "none";
    }
</script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/catalogScript.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/script.js"></script>
</body>
</html>

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
    <div class="adminActions">
        <button id="userListButton" class="listOfUsersButton" type="submit">User List</button>
        <button id="roomListButton" class="listOfRoomButton" type="submit">Room List</button>
        <button id="applicationListButton" class="listOfApplicationButton" type="submit">Application List</button>
        <button id="ConfirmationListButton" class="listOfConfirmationButton" type="submit">Confirmation of admin
        </button>

        <table id="tableOfUsers">
            <tr>
                <th>Id</th>
                <th>Email</th>
                <th>Name</th>
                <th>Admin</th>
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
                <th>Id</th>
                <th>Price</th>
                <th>Amount of the seats</th>
                <th>Status of the room</th>
                <th>Class of the room</th>
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
                <th>Id</th>
                <th>Price</th>
                <th>Amount of the seats</th>
                <th>Status of the room</th>
                <th>Class of the room</th>
            </tr>
            <c:forEach var="application" items="${applicationList}">
                <tr>
                    <td>${application.getId()}</td>
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
                    <input type="text" name="user_admin_id">
                    <input type="text" name="room_admin_id">
                </div>
                <button class="btn confirmation" type="submit"><label>confirm</label></button>
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

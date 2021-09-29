 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <fmt:setLocale value="${language}"/>
 <fmt:setBundle basename="res"/>
 <form action="LoginServlet" class="form" method="post">
            <div class="gall">
                <img alt="Eventy" src="images/picture.jpg">
            </div>
            <fmt:message key="Email" var="Email"/>
            <input class="input" type = "email" name = "Email" placeholder="${Email}">
            <fmt:message key="Password" var="Password"/>
            <input class="input" type = "password" name = "Password" placeholder="${Password}">
            <button class="btny" type="submit"><label><fmt:message key="log_in"/></label></button>
 </form>
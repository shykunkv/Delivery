<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<center>
    <p>
        <a href="<spring:url value="/jsp/" />">Home</a>
        |
        <a href="<spring:url value="/jsp/menu" />">Menu</a>
        |
        <security:authorize access="!isAuthenticated()">
            <a href="<spring:url value="/jsp/login" />">Login</a>
            |
            <a href="<spring:url value="/jsp/register" />">Register</a>
        </security:authorize>

        <security:authorize access="isAuthenticated()">
            <a href="#">Personal info</a>
            |
            <a href="<c:url value="/jsp/logout" />" > Logout</a>
        </security:authorize>
    </p>
</center>

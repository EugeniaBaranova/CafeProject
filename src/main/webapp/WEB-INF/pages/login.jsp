<%@ page language="java" contentType = "text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <body>
    <c:if test="${sessionScope.user.role eq 'admin'}"/>
        <jsp:include page="../fragments/header.jspf"/>
        <form action="${pageContext.servletContext.contextPath}/controller?command=login" method="POST"/>
             <label title="Login">
                <input type="text" name="login"/>
             </label>
             <label title="Password">
                <input type="password" name="password"/>
             </label>
             <input type="submit" value="Enter">
        </form>
    </body>
</html>
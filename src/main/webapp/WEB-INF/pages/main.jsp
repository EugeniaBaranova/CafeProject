<%@ page language="java" contentType = "text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <body>
    <c:if test="${sessionScope.user.role eq 'admin'}"/>
        <jsp:include page="../fragments/header.jspf"/>
        </form>
    </body>
</html>
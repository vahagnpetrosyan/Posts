<%--
  Created by IntelliJ IDEA.
  User: vahagn
  Date: 2/1/18
  Time: 1:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Profile</title>
    <title>Register</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/style.css" />" >
</head>
<body>
    <h1><spring:message code="user.profile"/></h1>
    <c:out value="${user.username}"/><br/>
    <c:out value="${user.firstName}"/> <c:out value="${user.lastName}"/><br/>
    <c:out value="${user.email}"/>
</body>
</html>

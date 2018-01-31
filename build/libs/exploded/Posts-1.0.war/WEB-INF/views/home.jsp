<%--
  Created by IntelliJ IDEA.
  User: vahagn
  Date: 1/31/18
  Time: 10:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
    <title>Posts</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/style.css" />" >
</head>
<body>
    <h1><spring:message code="posts.welcome"/></h1>

    <spring:url value="posts" var="postURL"/>
    <spring:url value="register" var="resgisterURL"/>

    <a href="${postURL}">Posts</a>
    <a href="${resgisterURL}">Register</a>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: vahagn
  Date: 2/1/18
  Time: 12:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/style.css" />" >
</head>
<body>
    <h1>Registration</h1>
    <form:form method="post" commandName="user">
        <form:errors path="*" element="div" cssClass="error"/>
        <form:label path="firstName" cssErrorClass="error">Fisrt Name</form:label>
        <form:input path="firstName" cssErrorClass="error"/> <br/>
        <form:label path="lastName" cssErrorClass="error">Last Name</form:label>
        <form:input path="lastName" cssErrorClass="error"/> <br/>
        <form:label path="email" cssErrorClass="error">Email</form:label>
        <form:input path="email" cssErrorClass="error"/> <br/>
        <form:label path="username" cssErrorClass="error">Username</form:label>
        <form:input path="username" cssErrorClass="error"/> <br/>
        <form:label path="password" cssErrorClass="error">Password</form:label>
        <form:input path="password" cssErrorClass="error"/> <br/>
        <imput type="submit" value="Register"/>
    </form:form>

</body>
</html>

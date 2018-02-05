<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vahagn
  Date: 2/6/18
  Time: 12:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Posts</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/style.css" />"/>
</head>
<body>
    <div class = "postView">
        <div class="postMessage"> <c:out value="${post.message}"/></div>
        <div>
            <span class="postTime" > <c:out value="${post.time}"/></span>
        </div>
    </div>
</body>
</html>

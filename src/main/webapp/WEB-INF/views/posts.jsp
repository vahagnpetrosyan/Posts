<%--
  Created by IntelliJ IDEA.
  User: vahagn
  Date: 2/5/18
  Time: 11:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Posts</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/style.css" />"/>
</head>
<body>
    <div class="postForm">
        <form method="POST" name = "postForm">
            <input type="<textarea name=message" cols="80" rows="10"></textarea>"
        </form>
    </div>
    <div class="listPosts">
        <h1>Recent Posts</h1>
        <ul class="postsList">
            <c:forEach items="${postList}" var="post">
                <li id="post_<c:out value="${post.id}"/>">
                    <div class="posMessage" <c:out value="${post.message}"/>></div>
                    <div class="postTime">
                        <c:out value="${post.time}"/>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
    <c:if test="${fn:length(postList) gt 20}">
        <hr />
        <spring:url value="/spittles?count=${fn:length(postList) + 20}" var="more_url" />
        <a href="${more_url}">Show more</a>
    </c:if>

</body>
</html>

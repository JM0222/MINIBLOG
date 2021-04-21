<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>블로그</title>
</head>
<body>
	<h1> ${authUser.id}의 블로그입니다</h1>
	<c:choose>
	<c:when test="${empty authUser }">
		<a href="<c:url value="/members/login"/>">로그인</a>
	</c:when>
	<c:otherwise>
		<a href="<c:url value="/${authUser.id}/admin/basic" />">내블로그관리</a>
		<a href="<c:url value="/members/logout" />">로그아웃</a>
	</c:otherwise>
	</c:choose>
</body>
</html>
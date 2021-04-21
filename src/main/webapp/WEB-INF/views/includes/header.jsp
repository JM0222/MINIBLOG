<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
*{
	margin:25px auto;
	}
	#container{


	text-align:center;

	}
	#section1 {

    margin:0px auto;
	
	

	}
	img {
		width:660px;
	}
	input{
		width:400px;
		height:25px;

	}
</style>
<body>
	<div id="container">
		<h1 onclick="alert()">JBLOG</h1>
		<div id="section1">
			<ul>
			<c:choose>
			<c:when test="${empty authUser }">
				<li><a href="<c:url value="/members/login"/>">로그인</a></li>
				<li><a href="<c:url value="/members/join" />">회원가입</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="<c:url value="/members/logout" />">로그아웃</a></li>
				<li><a href="<c:url value="/${authUser.id}" />">내블로그</a></li>
			</c:otherwise>
			</c:choose>
			</ul>
		</div>
	</div>
</body>
</html>
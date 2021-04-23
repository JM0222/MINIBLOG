<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jblog</title>
<style>
html{
	background-image: url("../img/1.png");
	background-color:black;
	}
</style>
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
	<h1>"회원가입 완료"</h1>
	<a href="<c:url value="/members/login"/>">로그인하기</a>
			</div>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인폼</title>
<style>
	html{
	background-image: url("../img/1.png");
	}
	input{
		display:flex;
		text-align:center;
		justify-content:center;
		color:black;
	}
	input[type="submit"]{
		height:50px;
		color:black;
	}
	input[type="text"]{
		width:400px;

	}
	input:hover, textarea:hover,
	input:focus, textarea:focus {
    background-color:#BDB3B1;
	}

		
	
</style>
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
	<fieldset>
	<h1>로그인</h1>
		<form id="login-form" 
		name="loginform" 
		method="POST" 
		action="<c:url value="/members/login"/>">
		<input type="hidden" name="blogkey" value="${id }">
		<label class="block-label" for="id">아이디</label> 
		<input id="id" name="id" type="text" value="" placeholder="아이디를 입력해주세요"><br>

		<label class="block-label">비밀번호</label> 
		<input name="password" type="password" value="" placeholder="비밀번호를 입력해주세요"><br>

		<input type="submit" value="로그인">
	</form>
	</fieldset>
			</div>
		</div>
	</div>
</body>
</html>
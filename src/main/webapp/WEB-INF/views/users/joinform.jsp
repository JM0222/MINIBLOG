<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<!-- jQuery -->
<script src="<c:url value="/assets/javascript/jquery/jquery-3.6.0.js"/>"></script>
<!-- 스크립트 삽입 -->
<script src="<c:url value="/assets/javascript/jquery/members.js"/>"></script>
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
		<div id="wrapper">
			<div id="content">
	<h1>조인폼입니다</h1>
	
	<form
		id="join-form"
		name="registerForm" 
		action="<c:url value="/members/join"/>"
		method="POST" onsubmit="return checkForm(this)"
		>
		<input type="hidden" name="check" value="f">
		<input type="hidden" name="a" value="join">
		<input type="hidden" name="blogTitle" value="널값">
		
		<label for="name">이름</label>
		<input name="userName" type="text" placeholder="이름을 입력하십시오"><br>
	
		<label for="id">아이디</label>
		<input type="text" name="id" placeholder="이메일을 입력하십시오."><br>
		
		<label for="password">비밀번호</label>
		<input name="password" type="password" placeholder="비밀번호를 입력하십시오"><br>
		<label for="ag">약관동의</label>
		<input type="radio" name="ag" value="ok" checked>YES</radio>
		<input type="radio" name="ag" value="no">NO</radio><br>
		
		<!-- 이메일 체크 버튼 -->
		<input type="button" 
			value="아이디 중복 체크"
			onclick="checkid(this.form.id,
			 '<c:url value="/members/idcheck" />')" /><br>
		<input type="submit" value="전송">
		<!--  input type="button" value="폼 검증" onclick="checkForm(this.form)" --> 
	
	</form>
	
	
			</div>
		</div>
	</div>
</body>
</html>
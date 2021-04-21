<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설정</title>
</head>
<body>
	<h1> ${vo.getBlogTitle()}</h1>
	<a href="">기본설정</a><br>
	<a href="">카테고리 설정</a><br>
	<a href="">글 작성</a><br>
	<form method="POST">
	
		<label for = "titlename">블로그제목</label>
		<input type= "text" name="blogTitle" value="${vo.getBlogTitle()}"><br>
		<input type ="submit" value="블로그명 변경하기">
		<input id="userNo" name="userNo" type="hidden" value="${vo.getUserNo() }">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설정</title>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
<style>
*:not(html){
	margin:25px auto;
	font-family: 'Do Hyeon', sans-serif;
	font-size: 1.1em;
	color: white;

	}
html{
	background-image: url("https://cdn.pixabay.com/photo/2016/11/30/20/58/programming-1873854_1280.png");
 	background-repeat: no-repeat; 
 	background-size: cover;
	}
input[type="submit"]{
		height:65px;
		color:black;
		margin-left:25px;
		horizontal-align:left;
	}
	input[type="file"]{
		color:white;
	}
	a{
	display:flex;
	justify-content:center;
	text-align:center;
	}
	form{
	margin-left:200px;
	font-size:2em;
	}
	h1{
	font-size:2.5em;
	text-align:center;
	}
	input{
color:black;
}

	
</style>
</head>
<body>
</div>
	<h1> ${vo.getBlogTitle()}</h1>
	<a href = "<c:url value="basic"/>">기본설정</a>
	<a href = "<c:url value="category"/>">카테고리 설정</a>
	<a href="<c:url value="post"/>">글작성</a>
	<form method="POST" action="update"
	enctype="multipart/form-data">
		<label for = "titlename">블로그제목</label>
		<input type= "text" name="blogTitle" value="${vo.getBlogTitle()}"><br>
		<input id="userNo" name="userNo" type="hidden" value="${vo.getUserNo() }">
		<label>파일</label>
		<input type="file" name="uploadfile"><br>
		<input type ="submit" value="기본설정 변경하기">
	</form>
</body>
</html>
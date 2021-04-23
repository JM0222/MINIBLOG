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
html{
	background-image: url("https://cdn.pixabay.com/photo/2016/11/30/20/58/programming-1873854_1280.png");
 	background-repeat: no-repeat; 
 	background-size: cover;
	}
	*:not(html){
	margin:25px auto;
	font-family: 'Do Hyeon', sans-serif;
	font-size: 1.1em;
	color: white;
	}
	input[type="submit"]{
		color:black;
		justify-content:center;
	}
	a{
	display:flex;
	text-align:center;
	justify-content:center;
	}
	input{
		color:black;
		margin-left:50px;
	}
	table {
	  width: 80%;
	  border-collapse: collapse;
	  background: #34495e;
	  color: #f3f3f3;
	}
	
	td, th {
	  padding: 8px;
	  text-align: left;
	}
	tr:nth-of-type(odd) {
	  background: black;
	}
	
	th {
	  background: #2c3e50;
	  font-weight: bold;
	}
	label{
	margin-left:200px;
	}
	h1{
	margin-left:200px;
	font-size:2em;
	}
	

</style>
</head>
<body>
	<a href = "<c:url value="basic"/>">기본설정</a>
	<a href = "<c:url value="category"/>">카테고리 설정</a>
	<a href="<c:url value="post"/>">글작성</a>
	
	
	
	<table border ="1" width="1000">
		<tr>
			<th>번호</th>
			<th>카테고리명</th>
			<th>포스트수</th>
			<th>설명</th>
			<th>등록일</th>
			<th>삭제</th>
		</tr>
		<c:forEach items="${list}" var ="vo">
		<tr>
			<td>${vo.getCateNo()}</td>
			<td>${vo.getCateName()}</td>
			<td>???</td>
			<td>${vo.getDescription()}</td>
			<td>${vo.getRegDate()}</td>
			<td>
				<form method="POST" action="<c:url value="delete"/>">
					<input type="hidden" name = "no" value= "${vo.getCateNo()}">
					<input type="submit" value="삭제">
				</form>
			</td>
		</tr>
		</c:forEach>
		<h1>새로운 카테고리 추가</h1>
		<form method = "POST">
			
			<label for = "cateName">카테고리명</label>
			<input id = "cateName" name ="cateName" type = "text">
			
			<label for = "description">설명</label>
			<input id = "description" name ="description" type = "text">
			
			<input id = "userNo" name = "userNo" type = "hidden" value="${authUser.getUserNo() }">
			<input type="submit" value="카테고리 추가">
		</form>
		
		
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글작성</title>
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
a{
	display:flex;
	justify-content:center;
	text-align:center;
	text-decoration:none;
}
a:hover{
	color:skyblue;
}
#section{
	display:flex;
	justify-content:center;
	text-align:center;
	text-decoraion:none;

}
input {
	color:black;
}
option {
	color:black;
}
select {
	color:black;
}
td {
	text-align:center;
	background:black;
}
textarea {
	color:black;
}
input[type="submit"]:hover{
		background:black;
		color:white;
	}

</style>
</head>
<body>
	<a href = "<c:url value="basic"/>">기본설정</a>
	<a href = "<c:url value="category"/>">카테고리 설정</a>
	<a href="<c:url value="post"/>">글작성</a>
	
	
	<form method = "post">
		<table border = "1" width="1200">
			<tr>
				<td>제목</td>
				<td>
					<input type="text" name = "postTitle" style=width:1100px;>
				</td>
			</tr>
			<tr >
				<td>내용</td>
				<td>
					<textarea id = "postContent" name = "postContent" style=width:1100px;></textarea>
				</td>
			</tr>
			<div id="section">
			<h2>카테고리</h2>
			<select id = "cateNo" name ="cateNo">
				<c:forEach items="${list}" var="cateVo">
					<option value = "${cateVo.getCateNo()}">${cateVo.getCateName()}
					</option>
				</c:forEach>
			</select>
			
				<input type="submit" value="포스트 하기">
			</div>
		
		
		
		</table>
	</form>
</body>
</html>
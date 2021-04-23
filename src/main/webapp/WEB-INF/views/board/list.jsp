<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>블로그</title>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
<style>
html{
	background-image: url("img/1.png");
	}
	*{
	margin:25px auto;
	font-family: 'Do Hyeon', sans-serif;
	font-size: 1.1em;
	color: white;
	}
#section3{
border:3px solid white;
display:flex;
	justify-content:center;
	text-align:center;}
	#section4{
border:3px solid white;
display:flex;
	justify-content:center;
	text-align:center;}
#section1{
	border:3px solid white;
	display:flex;
	justify-content:center;
	text-align:center;
}
#section2{
border:3px solid white;
	display:flex;
	text-align:center;
}
input{
color:black;
}
img{
border-radius:30px;
float:left;
width:30%;
}
input[type="submit"]:hover{
		background:black;
		color:white;
	}
	a:hover{
		color:skyblue;
	}
	a{
	text-decoration:none;
	}
</style>
</head>

<body>
	<div id=section1>
	<img src="${pageContext.request.contextPath}/${vo.getLogoFile()}">
	<h1> ${authUser.id}의 블로그입니다</h1>
	<h2> ${vo.getBlogTitle() }</h2>

	<c:choose>
	<c:when test="${empty authUser }">
		<a href="<c:url value="/members/login"/>">로그인</a>
	</c:when>
	<c:otherwise>
		<a href="<c:url value="/${authUser.id}/admin/basic" />">내블로그관리</a>
		<a href="<c:url value="/members/logout" />">로그아웃</a>
	</c:otherwise>
	</c:choose>
	</div>
	<div id=section2>
	<h3>최근 포스트</h3>
	${postList[0].getPostTitle()}
	${postList[0].getPostContent()}
	</div>
	<div id=section4>
	<h3>카테고리</h3>
	<c:forEach items="${cateList}" var="cate">
			<form method = "POST">
				<input type="hidden" name = "cateNo" id = "cateNo" value = "${cate.getCateNo() }">
				<input type="submit" id= "but" value = "${cate.getCateName() }">
			</form>	
	</c:forEach>
	</div>
	<div id=section3>
	<h3>포스트종류</h3>
	<c:forEach items="${postList}" var="catePost">
		<p>${catePost.getPostTitle() }</p>
		<p>${catePost.getRegDate() }</p>
	</c:forEach>
	</div>
</body>
</html>
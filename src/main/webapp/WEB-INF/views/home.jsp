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
	background-image: url("img/1.png");
	}
.clouds {
		overflow: hidden;
		top:0;
	    left:0;
	    width: 100%;
	    height: 100%;
}
.clouds img
{
    position: absolute;
    bottom: 0;
    max-width: 50%;
    animation: animate calc(8s * var(--i)) linear infinite;
}
@keyframes animate
{
    0%
    {
        transform: translateX(-100%);
    }
    100%
    {
        transform: translateX(100%);
    }
}
button{
	color:black;
}
button:hover{
background-color:#534B4B;
}
a{
text-decoration:none;
}
a:hover{
	color:skyblue;
}
input[type="submit"]:hover,input[type="button"]:hover{
	background:black;
	color:white;
}
h1{
animation: h1Ani;
animation-duration: 1.5s;
}
@keyframes h1Ani
{
	0%
	{
		transform: scale(1.0);
		opacity: 0;
	}
	100%
	{
		transform: scale(2.0);
		opacity: 1;
	}
}

</style>

</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
		<div id="wrapper">
			<div id="content">
				<input type="text" placeholder="어차피 검색안됨">
				<button type="button">검색</button>
			</div>
			<div class="clouds">
				<img src="img/cloud1.png" style="--i:1;">
	            <img src="img/cloud2.png" style="--i:2;">
	            <img src="img/cloud3.png" style="--i:3;">
	            <img src="img/cloud4.png" style="--i:4;">
	            <img src="img/cloud5.png" style="--i:5;">
			</div>
			
		</div>
	</div>
</body>
</html>
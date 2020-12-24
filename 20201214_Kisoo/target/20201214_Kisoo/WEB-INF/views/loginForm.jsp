<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<%@include file="./style.jsp"%>
<script type="text/javascript">

	window.onload = function(){
	document.getElementById('signUp').onclick = function(){
		location.href="./signUpForm.do"
		}
	};
	
</script>
</head>
<body>
	<div id="container">
		<h1>Login</h1>
		<div id="id">아이디</div>
		<form action="./login.do" method="post" name="form">
			<input type="hidden" id="loginChk" name="auth" value="0">
			<input type="text" name="id" id="InId" required placeholder="아이디 입력"/>
		<div id="pw">비밀번호</div>
		<input type="password" name="pw" id="inPw"><br>
		<input type="submit" id="login" name="login" class="btn btn-success" value="로그인">&nbsp;&nbsp;
		<input type="button" id="signUp" name="signUp" class="btn btn-warning" value="회원가입">	
		
		</form>
	</div>
</body>
</html>
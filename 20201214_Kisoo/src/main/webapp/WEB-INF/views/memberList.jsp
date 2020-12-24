<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 글 보기</title>
</head>
<%@include file="./style.jsp"%>
<body>
<div id='container' class="container">
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>연번</th>
				<th>아이디</th>
				<th>이름</th>
				<th>삭제여부</th>
				<th>권한</th>
				<th>등록일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${lists}" varStatus="vs">
				<tr>
				<td>${vs.count }</td>
				<td>${user.id }</td>
				<td>${user.name }</td>
				<td>${user.delflag }</td>
				<td>${user.auth == "U"?"사용자":"관리자"}</td>
				</tr>	
			</c:forEach>
		</tbody>
	</table>
	<div>
		<input class="btn btn_warning btn-block" type="button" value="돌아가기" onclick="history.back(-1)">
	</div>
</div>
</body>
</html>
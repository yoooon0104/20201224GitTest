<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="./style.jsp"%>
<meta charset="UTF-8">
<title>답글입력</title>
</head>
<body>
	<div id="container">
		<form action="./reply.do" method="post">
			<input type="hidden" name="seq" value="${seq }">
			<table class="table table-bordered">
				<tr>
					<td>작성자</td>
					<td><input type="text" id="id" name="id" ></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" id="title" name="title" ></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea rows="5" id="content" name="content" ></textarea></td>
				</tr>
			</table>	
				<input type="submit" value="답글 작성완료" class="btn btn-success">
				<input type="button" value="돌아가기" class="btn btn-success" onclick="history.back()">
		</form>
		</div>
</body>
</html>
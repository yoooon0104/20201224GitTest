<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="./style.jsp"%>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./insertBoard.do" method="post">
		<div id="container">
		<a onclick="history.back()">뒤로가기</a>
			<table class="table table-bordered">
				<tr>
					<td>작성자</td>
					<td><input type="text" id="id" name="id"></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" id="title" name="title"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea id="content" name="content" cols="100" rows="10"></textarea></td>
				</tr>
			</table>	
			<div class="form-group">
				<input type="submit" value="작성완료" class="btn btn-success">
				<input type="reset" value="다시작성" class="btn btn-success">
			</div>			
		</div>
	</form>
</body>
</html>
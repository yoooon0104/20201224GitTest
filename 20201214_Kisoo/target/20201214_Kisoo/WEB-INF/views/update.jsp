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
	<div id="container">
		<form action="./modifyBoard.do">
			<input type="hidden" name="seq" value="${dto.seq }">
			<table class="table table-bordered">
				<tr>
					<td>작성자</td>
					<td><input type="text" id="id" value="${dto.id}" readonly="readonly"></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" id="title" value="${dto.title }" readonly="readonly"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea rows="5" id="content" name="content" >${dto.content }</textarea></td>
				</tr>
			</table>	
				<input type="submit" class="btn btn-success" value ="수정완료">
				<input type="button" class="btn btn-success" value ="수정취소" onclick="history.back()">
		</form>
		</div>
</body>
</html>
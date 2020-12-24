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
		<form action="./goUpdateBoard.do" method="post">
			<input type="hidden" name="seq" value="${dto[0].seq }">
			<table class="table table-bordered">
				<tr>
					<td>작성자</td>
					<td><input type="text" id="id" name="id" readonly="readonly" value="${dto[0].id}"></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" id="title" name="title" readonly="readonly" value="${dto[0].title }"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea rows="5" id="content" name="content" readonly="readonly" >${dto[0].content }</textarea></td>
				</tr>
				<tr>
					<td>등록일</td>
					<td><input type="text" readonly="readonly" value="${dto[0].regdate }"></td>
				</tr>
			</table>	
				<input type="button" value="글 삭제" class="btn btn-success" onclick="location.href='./multiDelete.do?seq=${dto[0].seq}'">
				<input type="submit" value="글 수정" class="btn btn-success">
				<input type="button" value="답글입력" class="btn btn-success" onclick="location.href='./goReply.do?seq=${dto[0].seq}'">
		</form>
		</div>
</body>
</html>
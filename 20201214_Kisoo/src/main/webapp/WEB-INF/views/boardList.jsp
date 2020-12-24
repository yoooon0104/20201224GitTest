<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="./style.jsp"%>
<meta charset="UTF-8">
<title>글목록</title>
<script type="text/javascript">

	function goInsert() {
		location.href = './goInsert.do';
	}

	//전체선택
	function checkAll(bool) {
		var chk = document.getElementsByName('chk');
		for (var i = 0; i < chk.length; i++) {
			chk[i].checked = bool;
		}
	}

	function multiChk() {
		var chk = document.getElementsByName('chk');
		var n = 0;
		for (var i = 0; i < chk.length; i++) {
			if (chk[i].checked) {
				n++;
			}
		}
		if (n > 0) {
			//선택한갯수1개 이상이면 submit
			return true;
		} else {
			alert("삭제 할 1개 이상의 글을 선택해주세요.");
			return false;
		}
	}
</script>
</head>
<body>
	<c:if test="${mem != null }">
		<p><a href="./logout.do">로그아웃</a></p>
	</c:if>				
	<div class="container">	
		<form action="./multiDelete2.do" onsubmit="return multiChk();" method="post" id="frm">
			<div>
				<table class="table table-bordered">
					<tr>
						<th><input type="checkbox" onclick="checkAll(this.checked)"></th>
						<th>seq</th>
						<th>작성자</th>
						<th>제목</th>
						<th>작성일</th>
						<th>삭제여부</th>
					</tr>
				<jsp:useBean id="format" class = "com.min.edu.usebean.inputList" scope="page"/>
		     	<jsp:setProperty property="lists" name="format" value = "${list}"/>
		     	<jsp:getProperty property="listForm" name="format"/>
				</table>
			</div>
				<input type="button" onclick="goInsert()" value="글 작성" class="btn btn-success"> &nbsp;&nbsp;
				<input type="submit" value="삭제" class="btn btn-warning">
		</form>
	</div>
</body>
</html>
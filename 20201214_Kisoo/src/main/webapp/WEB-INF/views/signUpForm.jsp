<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<%@include file="./style.jsp"%>
<script type="text/javascript">

function check(){
	var id = document.getElementById('id').value;
	var pw = document.getElementById('pw').value;
	var name = document.getElementById('name').value;
	var pwChk = document.getElementById('pwChk').value;
	var chkVal = document.getElementById('chkVal').value;
	var frm = document.frm
	
	if(pw != pwChk){
		alert('비밀번호가 틀렸습니다. 다시 확인해주세요');
		return false;
	}else if(pw == ''){
		alert('비밀번호를 입력하세요');
		return false;
	}else if(pwChk == ''){
		alert('비밀번호를 확인 후 진행해주세요');
		return false;
	}else if(chkval == '0'){
		alert('아이디를 확인해주세요');
		return false;
	}else if(name == ''){
		alert('이름을 확인해주세요');
		return false;
	}else{
		return true;
	}
}
	$(document).ready(function(){
		$('#id').blur(function(){
			
			id = $('#id').val();
		    	   
		    	   $.ajax({
		    		   type : 'post',
		    		   url : './idCheck.do',
		    		   data : 'id='+id,
		    		   async : true,
		    		   success : function(msg){
		    			   console.log(msg)
		    			   if(msg == 'true'){
		    	                  $('#chkval').val('0');
		    	                  $('#rs').html('사용 불가능한 아이디입니다');
		    	                  $('#rs').css('color','red');
		    	               }else{
		    	                  $('#chkval').val('1');
		    	                  $('#rs').html('사용가능한 아이디입니다');
		    	                  $('#rs').css('color','green');
		    	               }
		    			   },
		    			   error : function(){
		    				   console.log('잘못된 요청 값입니다.');
		    			   }
		    	  	 });
			});
	});
</script>
</head>
<body>
	<div id="container">
		<h1>회원가입</h1>
		
		<input type="hidden" id="chkVal" value="0">
		<form action="./signUp.do" method="post" id="frm" name="frm" onsubmit="return check();">
			<input type="text" id="id" name="id" placeholder="아이디" required maxlength="20"><br>
			<span id="rs"></span><br> 
			<input type="password" id="pw" name="pw" placeholder="패스워드" required><br>
			<input type="password" id="pwChk" name="pwChk" placeholder="패스워드확인" required><br>
			<input type="text" id="name" name="name" placeholder="이름" required><br>
			
		
            <input class="btn btn-success" type="submit" value="회원가입">
            <input class="btn btn-primary" type="button" value="돌아가기" onclick="javascript:history.back(-1)">
		</form>
	</div>
</body>
</html>
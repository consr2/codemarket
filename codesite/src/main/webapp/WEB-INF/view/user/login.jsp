<%@page import="java.math.BigInteger"%>
<%@page import="java.security.SecureRandom"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/">홈으로</a>
	<form action="/user/login" method="POST" id="form">
		<div>
			<label>아이디</label>
			<input name="username" id="username">
		</div>
		<div>
			<label>비밀번호</label>
			<input type="password" name="password" id="password">
		</div>
		<button type="submit" >로그인</button>
	</form>
	<c:if test="${param.error != null}">
		<div>로그인 정보 오류</div>
	</c:if>
	<div id="naver_id_login"></div>

</body>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">

	var url = document.location.href
	var client_id = 'G6iQ2lkHhAgaArT3rKrt'
	

	var naver_id_login = new naver_id_login(client_id, url)
	var state = naver_id_login.getUniqState()
  	naver_id_login.setButton("green", 1,40)
  	naver_id_login.setDomain("http://localhost:8080/")
  	naver_id_login.setState(state)
  	naver_id_login.init_naver_id_login()
  	
	if(url.length > 150){
  		naver_id_login.get_naver_userprofile("sendinfo()")
	}
  	
  	let id = document.querySelector('#username')
	let pw = document.querySelector('#password')
	let form = document.querySelector('#form')
  	
  	function sendinfo(){
	  	$.ajax({
	  		url : '/user/login/naver',
	  		type : 'POST',
	  		data : {
	  			'username' : naver_id_login.getProfileData('name') + 
	  						naver_id_login.getProfileData('nickname'),
	  		  	'password' : naver_id_login.getProfileData('id'),
	  		},
	  		success : function(e){
	  			id.value = naver_id_login.getProfileData('name') + 
					naver_id_login.getProfileData('nickname')
	  			pw.value = naver_id_login.getProfileData('id')
	  			form.submit()
	  		}
	  	})
  	}

</script>
</html>
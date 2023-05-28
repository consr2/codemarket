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
	<!-- Google fonts-->
    <link href="https://fonts.googleapis.com/css?family=Saira+Extra+Condensed:500,700" rel="stylesheet" type="text/css" />
    <link href="https://fonts.googleapis.com/css?family=Muli:400,400i,800,800i" rel="stylesheet" type="text/css" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="../css/styles.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
 	<!-- Navigation-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top" id="sideNav">
        <a class="navbar-brand my-auto" href="/">
            <span class="">Code Site</span>
        </a>
    </nav>
	<div class="container mt-4">
		<div class="col-6 mx-auto">
			<form action="/user/login" method="POST" id="form" class="form-control">
				<div>
					<label class="form-label">아이디</label>
					<input name="username" id="username" class="form-control">
				</div>
				<div>
					<label class="form-label">비밀번호</label>
					<input type="password" name="password" id="password" class="form-control">
				</div>
				<div class="d-flex">
					<button type="submit" class="btn btn-primary btn-block text-light my-3">로그인</button>
					<div class="m-3" id="naverIdLogin">
						<img src="https://static.nid.naver.com/oauth/button_g.PNG?version=js-2.0.1" style="height: 40px"/>
					</div>
				</div>
			</form>
			<c:if test="${param.error != null}">
				<div class="text-danger">로그인 정보 오류</div>
			</c:if>
		</div>
	</div>

	<input id="client_id" value="${client_id}" hidden>
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">

	var url = window.location.protocol + "//" + window.location.host;
	var client_id = $('#client_id').val();
	var randomNum = Math.random() * 10000;
	var redirect_uri = url + '/user/login/naver';
	
	let popup = null
	
	$('#naverIdLogin').click(naverPop);
	function naverPop(){
		popup = window.open("https://nid.naver.com/oauth2.0/authorize?response_type=code" +
						"&client_id=" + client_id +
						"&state=" + randomNum +
						"&redirect_uri=" + redirect_uri
					,"네이버"
					,"width=400,height=400");
	}
	
	function closePop(data){
		popup.close();
		console.log(data);
		data = data.replace(/^[^\(]+\(|\)/g , '');
		var json = JSON.parse('{' + data.replace(/([\wㄱ-ㅎㅏ-ㅣ가-힣]+)=([\wㄱ-ㅎㅏ-ㅣ가-힣]+)/g, '"$1":"$2"') + '}');
		
		$.ajax({
			url: "/user/login"
			,type: "POST"
			,data: json
			,success: function(res){
				window.location.href = "/";
			}
			,error: function(xhr, state, error){
				console.log('실패')
				console.log(error)
			}
		})
	}
	
	
</script>
</html>
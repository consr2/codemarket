<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	*{
		margin:0;
		padding:0;
	}
	.container{
		width: 500px;
		margin: 0 auto;
		padding: 25px
	}
	.container h1{
		text-align: left;
		padding: 5px 5px 5px 15px;
		color: #FFBB00;
		border-left: 3px solid #FFBB00;
		margin-bottom: 20px;
	}
	.chating{
		background-color: #000;
		width: 500px;
		height: 500px;
		overflow: auto;
	}
	.chating p{
		color: #fff;
		text-align: left;
	}
	input{
		width: 330px;
		height: 25px;
	}
	#yourMsg{
		display: none;
	}
</style>
<body>
<a href="/">dd</a>
	<input type="hidden" id="sessionId" value="">
	<input type="hidden" id="roomNumber" value="${roomIdx}">
	<div id="container" class="container">
		<h1>채팅</h1>
		<div id="chating" class="chating"></div>
		
		<div id="yourMsg">
			<table class="inputTable">
				<tr>
					<th>메시지</th>
					<th><input id="chatting" placeholder="보내실 메시지를 입력하세요."></th>
					<th><button onclick="send()" id="sendBtn">보내기</button></th>
				</tr>
			</table>
		</div>
	</div>
	<sec:authorize access="isAuthenticated()">
		<div class="user" hidden="true">
			<sec:authentication property="principal.Username"/>
		</div>
	</sec:authorize>
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script src="../js/chat.js"></script>
</body>
</html>
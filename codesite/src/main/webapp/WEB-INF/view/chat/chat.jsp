<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<!-- Google fonts-->
    <link href="https://fonts.googleapis.com/css?family=Saira+Extra+Condensed:500,700" rel="stylesheet" type="text/css" />
    <link href="https://fonts.googleapis.com/css?family=Muli:400,400i,800,800i" rel="stylesheet" type="text/css" />
	<link href="../css/styles.css" rel="stylesheet" />
	<link href="../css/chat.css" rel="stylesheet" />
	<title>Insert title here</title>
</head>
<body>
	<!-- Navigation-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top" id="sideNav">
        <a class="navbar-brand my-auto" href="/">
            <span class="">Code Site</span>
        </a>
    </nav>
	<input type="hidden" id="sessionId" value="">
	<input type="hidden" id="roomIdx" value="${roomIdx}">
	<sec:authorize access="isAuthenticated()">
		<div class="user" hidden="true">
			<sec:authentication property="principal.Username"/>
		</div>
	</sec:authorize>
	
	<div id="container" class="container">
		<h3 class="text-primary mt-4">${chatDto.roomName}의 채팅방</h3>
		<div id="messageBox" class="messageBox"></div>
	
		<div id="yourMsg mr-4">
			<div class="row mt-2 px-2">
				<input id="chatting" placeholder="보내실 메시지를 입력하세요." class="col-10">
				<button onclick="send()" id="sendBtn" class="btn btn-primary text-white col-2">보내기</button>
			</div>
		</div>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script src="../js/chat.js"></script>
</body>
</html>
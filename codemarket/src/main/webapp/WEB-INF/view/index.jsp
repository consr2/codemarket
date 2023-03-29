<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>메인페이지</div>
	<div>
		<sec:authorize access="isAuthenticated()">
			<sec:authentication property="principal.username"/>
		</sec:authorize>
	</div>
	<div>
		<sec:authorize access="isAnonymous()">
			<a href="/user/login">로그인</a>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
			<a href="/user/logout">로그아웃</a>
		</sec:authorize>
	</div>
	<div>
		<a href="/bubble">버블정렬</a>
	</div>
	<div>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<a href="/user">유저 DB확인</a>
		</sec:authorize>
	</div>
	<div>
		<a href="/join">회원가입</a>
	</div>
</body>
</html>
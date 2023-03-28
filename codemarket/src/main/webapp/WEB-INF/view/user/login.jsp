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
	<a href="/">홈으로</a>
	<form action="/user/login" method="POST">
		<div>
			<label>아이디</label>
			<input name="username">
		</div>
		<div>
			<label>비밀번호</label>
			<input type="password" name="password">
		</div>
		<button type="submit">로그인</button>
	</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/">홈으로</a>
	<form action="/compress" method="POST">
		<div>
			<label>아무 글자 입력</label>
			<input name="str">
		</div>
		<button type="submit">정렬</button>
	</form >
	<p>입력값 : 
		<c:out value="{ ${ str } }"></c:out>
	</p>
	<p>출력값 : 
		<c:out value="{ ${ result } }"></c:out>
	</p>
	<p>메시지 : 
		<c:out value="${ msg }"></c:out>
	</p>
</body>
</html>
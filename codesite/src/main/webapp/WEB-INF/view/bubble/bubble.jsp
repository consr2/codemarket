<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/">홈으로</a>
	<form action="/bubble" method="POST">
		<div>
			<label>아무 숫자 입력 (,기준 자름)</label>
			<input name="value">
		</div>
		<button type="submit">정렬</button>
	</form >
	<p>입력값 : 
		<c:out value="{ ${ value } }"></c:out>
	</p>
	<p>출력값 : 
		{
		<c:forEach var="i" items="${sort}" varStatus="status">
			<c:if test="${fn:length(sort) > status.count }">
				<c:out value="${i},"></c:out>
			</c:if>
			<c:if test="${fn:length(sort) == status.count }">
				<c:out value="${i}"></c:out>
			</c:if>
		</c:forEach>
		}
	</p>
	<p>메시지 : 
		<c:out value="${ message }"></c:out>
	</p>
	
</body>
</html>
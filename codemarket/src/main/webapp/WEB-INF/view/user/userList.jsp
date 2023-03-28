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
	<c:forEach var="i" items="${ userList }">
		<div>
			idx : <c:out value="${ i.idx }"></c:out>
			id : <c:out value="${ i.username }"></c:out>
			pw : <c:out value="${ i.password }"></c:out>
		</div>
	</c:forEach>
</body>
</html>
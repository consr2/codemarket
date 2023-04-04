<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/">홈으로</a>
	<div>유저 목록</div>
	<table border="1">
		<tr>
			<th>이름</th>
			<th>권한</th>
			<th>조절</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="i" items="${userList }">
			<tr>
				<td>
					<c:out value="${i.username }"></c:out>
				</td>
				<td>
					<c:out value="${i.role }"></c:out>
				</td>
				<td>
					<form action="/user/up/${i.idx }" method="POST">
						<button type="submit">▲</button>
					</form>
					<form action="/user/down/${i.idx }" method="POST">
						<button type="submit">▼</button>
					</form>
				</td>
		
				<td>
					<form action="/user/${i.idx }" method="POST">
						<button type="submit">삭제</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
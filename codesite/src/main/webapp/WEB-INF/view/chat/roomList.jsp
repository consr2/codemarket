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
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
		</tr>
		<tr>
			<c:forEach var="i" items="${roomList}">
				<td>
					<c:out value="${i.idx }"></c:out>
				</td>
				<td>
					<a href="/chat/${i.idx}">
						<c:out value="${i.roomName }"></c:out>
					</a>
				</td>
			</c:forEach>
		</tr>	
	</table>
	<form action="/room" method="POST">
		<input name="roomName">
		<button type="submit">방 만들기</button>
	</form>
</body>
</html>
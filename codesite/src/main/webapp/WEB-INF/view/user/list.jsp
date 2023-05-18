<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
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
		<div>유저 목록</div>
		<table class="table">
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
    </div>
</body>
</html>
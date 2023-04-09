<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
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
    	<div class="col-7 mx-auto">
		<form action="/bubble" method="POST" class="form-control">
			<div>
				<label class="form-label">숫자 입력 (ex 11,2,5,3,13)</label>
				<input name="value" class="form-control">
				<button type="submit" class="btn btn-primary btn-block text-light my-3">정렬</button>
			</div>
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
		</div>
	</div>
</body>
</html>
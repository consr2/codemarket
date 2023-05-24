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
	<title>회원가입</title>
</head>
<body>
	<!-- Navigation-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top" id="sideNav">
        <a class="navbar-brand my-auto" href="/">
            <span class="">Code Site</span>
        </a>
    </nav>
    <div class="container mt-4">
    	<div class="col-6 mx-auto">
			<form action="/user/custom" method="POST" class="form-control">
				<div>
					<strong class="form-label">아이디 : </strong>
					<c:out value="${user.username}"></c:out>
					<input type="hidden" name="username" value="${user.username }">
				</div>
				<div>
					<label class="form-label pt-2">닉네임</label>
					<input type="text" class="pw2 form-control" autocomplete="off" name="nickname" value="${user.nickname }">
				</div>
				<button type="submit" class="btn btn-primary btn-block text-light my-3">수정</button>
			</form>
    	</div>
    </div>
</body>
</html>
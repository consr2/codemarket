<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
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
		<table class="table">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>방장</th>
				<th>인원</th>
				<sec:authorize access="isAuthenticated()">
					<th>삭제</th>
				</sec:authorize>
			</tr>
			<c:forEach var="i" items="${roomList}">
				<tr>
					<td>
						<c:out value="${i.idx }"></c:out>
					</td>
					<td>
						<a href="/chat/${i.idx}">
							<c:out value="${i.roomName }"></c:out>
						</a>
					</td>
					<td>
						<c:out value="${i.host }"></c:out>
					</td>
					<td>
						<c:out value="${i.currentMember} /"></c:out>
						<c:out value="${i.maxMember}"></c:out>
					
					</td>
					<c:if test="${i.deleteCheck == true }">
						<td>
							<a href="/room/delete/${i.idx}">삭제</a>
						</td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
		
		<sec:authorize access="isAuthenticated()">
			<!-- Button trigger modal -->
			<button type="button" class="btn btn-primary btn-modal" data-toggle="modal" data-target="#exampleModal">
			  채팅방 만들기
			</button>
			
			<!-- Modal -->
			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel">방 생성</h5>
			      </div>
			      <div class="modal-body">
			      	<form action="/room" method="POST" onsubmit="return check()" class="form-control">
			      		<div>
					        <label class="form-label">방이름</label>
					        <input name="roomName" value="" class="roomName form-control">
			      		</div>
			      		<div>
					        <label class="form-label">최대인원 수</label>
					        <input name="maxMember" value="" type="number" class="maxMember form-control">
			      		</div>
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
				        <button type="submit" class="btn btn-primary btncheck">만들기</button>
				      </div>
			     	</form>
			    </div>
			  </div>
			</div>
		</sec:authorize>
	</div>
</body>
<!-- Bootstrap core JS-->
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"></script>
<script type="text/javascript">
	let roomName = document.querySelector('.roomName')
	let maxMember = document.querySelector('.maxMember')

	function check(){
		console.log("name : " + roomName.value)
		console.log("num : " + maxMember.value)
		if(roomName.value.length > 0 && maxMember.value > 1){
			return true
		}else{
			alert("제목 1자 이상 \n인원 2인 이상")
			return false
		}
	}
</script>
</html>
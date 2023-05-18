<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
			<form action="/join" method="POST" onsubmit="return submit1()" id="form" class="form-control">
				<div>
					<label class="form-label">아이디</label>
					<input type="text" name="username" value="" autocomplete="off" class="id form-control">
					<div class="error text-end" style="display:none">에러출력</div>
				</div>
				<div>
					<label class="form-label pt-2">비밀번호</label>
					<input type="password" name="password" value="" autocomplete="off" class="pw1 form-control">
					<div class="error text-end" style="display:none">에러출력</div>
				<div>
				</div>
					<label class="form-label pt-2">비밀번호 확인</label>
					<input type="password" class="pw2 form-control" autocomplete="off">
					<div class="error text-end" style="display:none">에러출력</div>
				</div>
				<button type="submit" class="btn btn-primary btn-block text-light my-3">회원가입</button>
			</form>
    	</div>
    </div>
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	let id = document.querySelector('.id')
	let pw = document.querySelector('.pw1')
	let pw2 = document.querySelector('.pw2')
	let btn = document.querySelector('.btn')
	let form = document.querySelector('#btn')
	let error = document.querySelectorAll('.error')
	
	
	id.addEventListener('focusout',checkId)
	pw.addEventListener('focusout',checkPw)
	pw2.addEventListener('focusout',checkPw2)

	function checkId(){
		if(id.value == ""){
			error[0].innerHTML='빈칸입니다'
			error[0].style.display='block'
			error[0].style.color='red'
			error[0].value = 0
		}else{
			ajaxId()
		}
	}
	
	function checkPw(){
		if(pw.value == ""){
			error[1].innerHTML='빈칸입니다'
			error[1].style.display='block'
			error[1].style.color='red'
			error[1].value = 0
		}else{
			error[1].style.display='none'
			error[1].value = 1
		}
	}
	
	function checkPw2(){
		if(pw2.value == ""){
			error[2].innerHTML='빈칸입니다'
			error[2].style.display='block'
			error[2].style.color='red'
			error[2].value = 0
			return
		}
		if(pw.value == pw2.value){
			error[2].innerHTML='비밀번호 일치'
			error[2].style.display='block'
			error[2].style.color='green'
			error[2].value = 1
		}else{
			error[2].innerHTML='비밀번호 불일치'
			error[2].style.display='block'
			error[2].style.color='red'
			error[2].value = 0
		}
	}
	
	function ajaxId(){
		$.ajax({
			url : '/api/user',
			type : 'GET',
			data : {
				'username' : id.value
			},
			success : function(response){
				if(response.username == id.value){
					error[0].innerHTML='이미 존재하는 아이디입니다.'
					error[0].style.display='block'
					error[0].style.color='red'
					error[0].value = 0
				}else{
					error[0].innerHTML='사용가능한 아이디입니다.'
					error[0].style.display='block'
					error[0].style.color='green'
					error[0].value = 1
				}
			}
		})
	}
	
	function submit1(){
		var count = 0
		error.forEach(e => {
			if(e.value == 1) count++
		})
		if(count == 3){
			return true
		}else{
			return false
		}
	}


</script>
</html>
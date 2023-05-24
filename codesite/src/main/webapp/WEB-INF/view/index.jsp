<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="kor">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>CodeSite</title>
        <link rel="icon" type="image/x-icon" href="assets/img/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Saira+Extra+Condensed:500,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Muli:400,400i,800,800i" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body id="page-top">
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top" id="sideNav">
            <a class="navbar-brand js-scroll-trigger" href="#page-top">
                <span class="d-block">Code Site</span>
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link js-scroll-trigger" href="#login">로그인</a></li>
                    <li class="nav-item"><a class="nav-link js-scroll-trigger" href="#algorithms">알고리즘</a></li>
                    <li class="nav-item"><a class="nav-link js-scroll-trigger" href="#board">게시글</a></li>
                    <li class="nav-item"><a class="nav-link js-scroll-trigger" href="#chat">채팅</a></li>
                    <li class="nav-item"><a class="nav-link js-scroll-trigger" href="#map">지도</a></li>
                    <li class="nav-item"><a class="nav-link js-scroll-trigger" href="#socal">소셜</a></li>
                </ul>
            </div>
        </nav>
        <!-- Page Content-->
        <div class="container-fluid p-0">
            <!-- About-->
            <section class="resume-section" id="login">
                <div class="resume-section-content">
                    <h1 class="mb-0">
                        Code
                        <span class="text-primary">Site</span>
                    </h1>
                    <div class="subheading mb-5">
                        이것 저것 잡다한 코딩 생각들을 모아놓은 사이트 입니다.
                    </div>
                    
                   	<ul class="list-unstyled">
                   		<sec:authorize access="isAnonymous()">
		                    <li>
		                    	<a href="/user/login" class="text-decoration-none">> 로그인</a>
		                    </li>
		                    <li>
	                    		<a href="/user/join" class="text-decoration-none">> 회원가입</a>
	                    	</li>
                   		</sec:authorize>
                   		<sec:authorize access="isAuthenticated()">
                   			<li>
                   				<sec:authentication property="principal.nickname"/>님!
                   			</li>
                   			<li>
		                    	<a href="/user/logout" class="text-decoration-none">> 로그아웃</a>
		                    </li>
		                    <li>
		                    	<a href="/user/custom" class="text-decoration-none">> 회원정보수정</a>
		                    </li>
                   		</sec:authorize>
                   		<sec:authorize access="hasRole('ROLE_ADMIN')">
							<a href="/user/list" class="text-decoration-none">> 유저 목록</a>
						</sec:authorize>
                   	</ul>
                    
                </div>
            </section>
            <hr class="m-0" />
            <!-- Experience-->
            <section class="resume-section" id="algorithms">
                <div class="resume-section-content">
                    <h2 class="mb-5">알고리즘</h2>
                    <div class="d-flex flex-column flex-md-row justify-content-between mb-5">
                        <div class="flex-grow-1">
                            <h3 class="mb-0">버블정렬(Bubble sort)</h3>
                            <div class="subheading mb-3">정수를 크기별로 정렬해주는 알고리즘 입니다.</div>
                            <p>
                            	<a href="/algorithm/bubble" class="text-decoration-none">> 버블정렬</a>
                            </p>
                        </div>
                        <div class="flex-shrink-0"><span class="badge bg-primary">2023-03-26</span></div>
                    </div>
                    <div class="d-flex flex-column flex-md-row justify-content-between mb-5">
                        <div class="flex-grow-1">
                            <h3 class="mb-0">문자열 압축</h3>
                            <div class="subheading mb-3">중복된 문자열을 체크후 압축</div>
                            <p>
                            	<a href="/algorithm/compress" class="text-decoration-none">> 문자열 압축</a>
                            </p>
                        </div>
                        <div class="flex-shrink-0"><span class="badge bg-primary">2023-03-30</span></div>
                    </div>
                </div>
            </section>
            <hr class="m-0" />
            <!-- Education-->
            <section class="resume-section" id="board">
                <div class="resume-section-content">
                    <h2 class="mb-5">게시글</h2>
                    <div class="d-flex flex-column flex-md-row justify-content-between mb-5">
                        <div class="flex-grow-1">
                            <h3 class="mb-3">제목</h3>
                            <div>본문</div>
                        </div>
                        <div class="flex-shrink-0"><span class="badge bg-primary">작성일</span></div>
                    </div>
                </div>
            </section>
            <hr class="m-0" />
            <!-- Skills-->
            <section class="resume-section" id="chat">
                <div class="resume-section-content">
                    <h2 class="mb-3">채팅</h2>
                    <div class="subheading mb-3">Web Socket 사용</div>
                    
                    <div class="subheading mb-3">
                    	<a href="/chat/roomlist" class="text-decoration-none">채팅방 입장</a>
                    </div>
                    <ul class="fa-ul mb-0" id="roomList">
						<li>바로가기</li>
                    </ul>
                </div>
            </section>
            <hr class="m-0" />
            <!-- Map-->
            <section class="resume-section" id="map">
                <div class="resume-section-content">
                    <h2 class="mb-3">지도 API</h2>
                    <div class="subheading mb-3">카카오 맵</div>
                    <div class="subheading mb-3">
                    	<a href="/map" class="text-decoration-none">지도 보기</a>
                    </div>
                </div>
            </section>
            <hr class="m-0" />
            <!-- Awards-->
            <section class="resume-section" id="socal">
                <div class="resume-section-content">
                    <h2 class="mb-5">소셜 & Contect</h2>
                    <div class="social-icons">
                        <a class="social-icon" href="#!"><i class="fab fa-github"></i></a>
                        <a class="social-icon" href="#!"><i class="fas fa-envelope-square"></i></a>
                        <a class="social-icon" href="#!"><i class="far fa-file-code"></i></a>
                    </div>
                </div>
            </section>
        </div>
        <script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>

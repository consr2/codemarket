	
	let ws;
	let userName = document.querySelector('.user')
	
	//소켓 명령어 모음
	function wsEvt() {
		//소켓이 열리면 동작
		ws.onopen = function(data){
			console.log("소켓 열림 : " + data)
		}
		
		//메시지를 받으면 동작
		ws.onmessage = function(data) {
			let msg = data.data;
			let json = JSON.parse(msg);
			
			if(json.type == 'session'){
				$('#sessionId').val(json.sessionId)
				return
			}
			
			if(json.sessionId == $("#sessionId").val()){
				$("#messageBox").append("<p class='me'>" + json.msg + " :나</p>");	
				scroll()
			}else{
				$("#messageBox").append("<p class='others'>" + json.userName + " :" + json.msg + "</p>");
				scroll()
			}
		}
	
		document.addEventListener("keypress", function(e){
			if(e.keyCode == 13){ //enter press
				send();
			}
		});
	}
	
	//아이디 체크
	$(window).on('load', function(){
		if(userName == null){
			userName = prompt('사용자 이름을 입력해주세요.','Guest');
			wsOpen();
			$("#yourMsg").show();
		}else{
			userName = userName.innerHTML.trim();
			wsOpen();
			$("#yourMsg").show();
		}
	})
	
	//소켓 생성
	function wsOpen(){
		ws = new WebSocket("ws://" + location.host + "/chating/" + $("#roomIdx").val());
		wsEvt();
	}
	
	//메시지 보내기
	function send() {
		var option ={
			type: "message",
			sessionId : $("#sessionId").val(),
			roomIdx : $("#roomIdx").val(),
			userName : userName,
			msg : $("#chatting").val()
		}
		ws.send(JSON.stringify(option))
		$('#chatting').val("");
	}

	function scroll(){
		var divdiv = document.getElementById("messageBox");
		divdiv.scrollTop = divdiv.scrollHeight;
	}

	
	
	
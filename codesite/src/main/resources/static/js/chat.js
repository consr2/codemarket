	
	let ws;
	let userName = document.querySelector('.user')
	
	//소켓 명령어 모음
	function wsEvt() {
		ws.onopen = function(data){
			//소켓이 열리면 동작
		}
		
		ws.onmessage = function(data) {
			//메시지를 받으면 동작
			var msg = data.data;
			if(msg != null && msg.trim() != ''){
				var d = JSON.parse(msg);
				if(d.type == "getId"){
					var si = d.sessionId != null ? d.sessionId : "";
					if(si != ''){
						$("#sessionId").val(si); 
					}
				}else if(d.type == "message"){
					if(d.sessionId == $("#sessionId").val()){
						$("#chating").append("<p class='me'>나 :" + d.msg + "</p>");	
					}else{
						$("#chating").append("<p class='others'>" + d.userName + " :" + d.msg + "</p>");
					}
						
				}else{
					console.warn("unknown type!")
				}
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
			userName = prompt("사용자 이름을 입력해주세요.");
			console.log("OFF : " +userName)
			$("#userName").focus();
		}else{
			userName = userName.innerHTML.trim();
			console.log("ON : " +userName)
			wsOpen();
			$("#yourMsg").show();
		}
	})
	
	//소켓 생성
	function wsOpen(){
		ws = new WebSocket("ws://" + location.host + "/chating");
		wsEvt();
	}
	
	//메시지 보내기
	function send() {
		console.log("data : " + $("#roomIdx").val())
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

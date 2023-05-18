package com.code.chat;


import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class WebSocketHandler extends TextWebSocketHandler{

	private List<ChatSession> sessionList = new ArrayList<>(); //웹소켓 세션을 담아둘 리스트
	
	@Override //메시지 받으면 뿌려줌
	public void handleTextMessage(WebSocketSession session, TextMessage message) {
		//메시지 발송
		String msg = message.getPayload();
		//sessionId, roomIdx, userName, msg
		JSONObject json = jsonToObjectParser(msg);
		String roomIdx = json.get("roomIdx").toString();
		
		for(ChatSession cs : sessionList) {
			if(roomIdx.equals(cs.getRoomIdx().toString())) {
				WebSocketSession wss = cs.getWs();
				try {
					wss.sendMessage(new TextMessage(json.toJSONString()));
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override //최초 소켓 생성
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		//리스트에 추가
		super.afterConnectionEstablished(session);
		sessionList.add(new ChatSession(session));
		log.info("소켓 생성 : " + session.toString());
		//소켓 연결
		JSONObject obj = new JSONObject();
		obj.put("type", "session");
		obj.put("sessionId", session.getId());
		session.sendMessage(new TextMessage(obj.toJSONString()));
	}
	
	@Override // 소켓 종료
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		//소켓 종료
		ChatSession cs = new ChatSession(session);
		log.info("소켓 종료 : " + session.toString());
		for(int i=0; i<sessionList.size(); i++) {
			if(sessionList.get(i).equals(cs)) {
				sessionList.remove(i);
			}
		}
		super.afterConnectionClosed(session, status);
	}

	//json 객체로 변환
	private static JSONObject jsonToObjectParser(String jsonStr) {
		JSONParser parser = new JSONParser();
		JSONObject obj = null;
		try {
			obj = (JSONObject) parser.parse(jsonStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public List<ChatSession> getSessionList() {
		return sessionList;
	}
}

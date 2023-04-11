package com.code.chat;

import java.util.Objects;

import org.springframework.web.socket.WebSocketSession;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ChatSession {

	private Long roomIdx;
	private String sessionId;
	private WebSocketSession ws;
	
	public ChatSession(WebSocketSession ws) {
		String roomIdx = ws.getUri().toString().split("/chating/")[1];
		String sessionId = ws.getId();
		this.roomIdx = Long.parseLong(roomIdx);
		this.sessionId = sessionId;
		this.ws = ws;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChatSession other = (ChatSession) obj;
		return Objects.equals(roomIdx, other.roomIdx) && Objects.equals(sessionId, other.sessionId);
	}
	
	
}

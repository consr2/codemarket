package com.code.chat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ChatRoomVo {

	private Long idx;
	private String roomName;
	
	@Builder
	public ChatRoomVo(String roomName) {
		this.roomName = roomName;
	}

}

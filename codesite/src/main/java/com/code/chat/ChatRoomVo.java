package com.code.chat;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class ChatRoomVo {

	private Long idx;
	private String roomName;
	private String host;
	private int maxMember;
	
	@Builder
	public ChatRoomVo(String roomName, String host, int maxMember) {
		this.roomName = roomName;
		this.host = host;
		this.maxMember = maxMember;
	}

}

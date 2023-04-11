package com.code.chat;

import java.security.Principal;
import java.util.List;

import com.code.user.UserDto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class ChatRoomDto {

	private Long idx;
	private String roomName;
	private String host;
	private int maxMember;
	private int currentMember;
	private boolean deleteCheck;
	
	public ChatRoomDto(ChatRoomVo vo) {
		this.idx = vo.getIdx();
		this.roomName = vo.getRoomName();
		this.host = vo.getHost();
		this.maxMember = vo.getMaxMember();
		this.deleteCheck = false;
	}
	
	public ChatRoomDto(ChatRoomVo vo, String username) {
		this.idx = vo.getIdx();
		this.roomName = vo.getRoomName();
		this.host = vo.getHost();
		this.maxMember = vo.getMaxMember();
		if(vo.getHost().equals(username)) {
			this.deleteCheck = true;
		}else {
			this.deleteCheck = false;
		}
	}
	
	public void addCurrentMember() {
		this.currentMember += 1;
	}
}

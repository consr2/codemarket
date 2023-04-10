package com.code.chat;

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
}

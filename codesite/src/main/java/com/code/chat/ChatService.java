package com.code.chat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatService {

	private final ChatMapper chatMapper;
	private Map<String, Object> roomList = new HashMap<>();
	
	public List<ChatRoomVo> findAll(){
		return chatMapper.findAll();
	}
	
	public void save(ChatRoomDto room) {
		ChatRoomVo vo = ChatRoomVo.builder()
				.roomName(room.getRoomName())
				.build();
				
		chatMapper.save(vo);
	}
	
}

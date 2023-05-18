package com.code.chat;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatService {

	private final ChatMapper chatMapper;
	@Autowired
	private WebSocketHandler webSocketHandler;
	
	public List<ChatRoomDto> findAll(Principal principal){
		List<ChatRoomDto> collect = new ArrayList<>();
		if(principal != null) {
			collect = chatMapper.findAll().stream()
					.map(m -> new ChatRoomDto(m, principal.getName())).collect(Collectors.toList());
		}else {
			collect = chatMapper.findAll().stream()
					.map(m -> new ChatRoomDto(m)).collect(Collectors.toList());
		}
		
		for(ChatRoomDto dto : collect) {
			currentMember(dto, webSocketHandler.getSessionList());
		}
		
		return collect;
	}
	
	public void save(ChatRoomDto room, Principal principal) {
		ChatRoomVo vo = ChatRoomVo.builder()
				.roomName(room.getRoomName())
				.host(principal.getName())
				.maxMember(room.getMaxMember())
				.build();
		log.info("DB 저장값 : " + vo.toString());
		chatMapper.save(vo);
	}
	

	public void delete(Long idx) {
		chatMapper.delete(idx);
	}
	
	public void currentMember(ChatRoomDto dto, List<ChatSession> list) {
		for(ChatSession session : list) {
			if(dto.getIdx() == session.getRoomIdx()) {
				dto.addCurrentMember();
			}
		}
	}
	
	public ChatRoomDto findById(Long idx) {
		ChatRoomDto dto = new ChatRoomDto(chatMapper.findById(idx));
		return dto;
	}
}

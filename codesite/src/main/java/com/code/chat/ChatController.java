package com.code.chat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ChatController{

	private final ChatService chatService;
	
	@GetMapping("/chat/{idx}")
    public String chatRoom(@PathVariable("idx")Long idx) {
        return "chat/chat";
    }

	@GetMapping("/room")
	public String roomList(Model model) {
		model.addAttribute("roomList", chatService.findAll());
		return "chat/roomList";
	}
	
	@PostMapping("/room")
	public String saveRoom(ChatRoomDto dto) {
		System.out.println("dto : " + dto.toString());
		chatService.save(dto);
		return "redirect:/room";
	}
}

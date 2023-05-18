package com.code.chat;

import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.code.result.Result;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ChatController{

	private final ChatService chatService;
	
	@GetMapping("/chat/{idx}")
    public String chatRoom(@PathVariable("idx")Long idx, Model model) {
		model.addAttribute("roomIdx",idx);
		model.addAttribute("chatDto", chatService.findById(idx));
        return "chat/chat";
    }

	@GetMapping("/chat/roomlist")
	public String roomList(Model model, Principal principal) {
		model.addAttribute("roomList", chatService.findAll(principal));
		return "chat/roomList";
	}
	
	@PostMapping("/room")
	public String saveRoom(ChatRoomDto dto, Principal principal) {
		chatService.save(dto, principal);
		return "redirect:/chat/roomlist";
	}
	
	@RequestMapping("/room/delete/{idx}")
	public String deleteRoom(@PathVariable("idx")Long idx) {
		chatService.delete(idx);
		return "redirect:/chat/roomlist";
	}
	
	@ResponseBody
	@GetMapping("/api/v1/chatroomList")
	public Result<List<ChatRoomDto>> apiRoomList(Principal principal) {
		List<ChatRoomDto> roomList = chatService.findAll(principal);
		return new Result<List<ChatRoomDto>>(roomList.size() ,roomList);
	}
	
}

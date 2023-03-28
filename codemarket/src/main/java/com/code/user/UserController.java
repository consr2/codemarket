package com.code.user;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
	@GetMapping("/api/user")
	@ResponseBody
	public UserVo findAll(String username) {
		return userService.findByUsername(username);
	}
	
	@GetMapping("/join")
	public String getJoin() {
		return "user/userJoin";
	}
	
	@PostMapping("/join")
	public String postJoin(UserDto userDto) {
		userService.save(userDto);
		return "redirect:/";
	}
	
	@GetMapping("/user/login")
	public String login() {
		return "user/login";
	}
	
}

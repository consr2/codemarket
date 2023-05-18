package com.code.user;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
	@GetMapping("/api/user")
	@ResponseBody
	public UserDto findUser(String username) {
		return userService.findByUsername(username);
	}
	
	@GetMapping("/user/join")
	public String getJoin() {
		return "user/join";
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
	
	@PostMapping("/user/login/naver")
	@ResponseBody
	public String naverLogin(UserDto userDto) {
		userService.save(userDto);
		return "1";
	}
	
	
	@GetMapping("/user/list")
	public String findAll(Model model) {
		List<UserDto> user = userService.findAll();
		model.addAttribute("userList", user);
		return "user/list";
	}
	
	@PostMapping("/user/{id}")
	public String deleteUser(@PathVariable("id")Long id) {
		System.out.println("받음" + id);
		userService.deleteUser(id);
		return "redirect:/user/list";
	}
	
	@PostMapping("/user/up/{id}")
	public String upUser(@PathVariable("id")Long id) {
		userService.upUser(id);
		return "redirect:/user/list";
	}
	@PostMapping("/user/down/{id}")
	public String downUser(@PathVariable("id")Long id) {
		userService.downUser(id);
		return "redirect:/user/list";
	}
}

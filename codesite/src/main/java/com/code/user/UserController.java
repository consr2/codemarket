package com.code.user;

import java.util.List;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.code.error.NaverError;
import com.code.security.UserExtend;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	private final NaverLoginService naverLoginService;
	
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
	public String login(Model model) {
		model.addAttribute("client_id", naverLoginService.getClient_id());
		return "user/login";
	}
	
	@GetMapping("/user/login/naver")
	public String naverLogin(HttpServletRequest request, Model model) throws NaverError{
		Map<String, Object> tokenMap = naverLoginService.getToken(request);
		Map<String, Object> userInfoMap = naverLoginService.getUserInfo(tokenMap);
		UserDto userDto = naverLoginService.getUserDto(userInfoMap);
		userService.save(userDto);
		model.addAttribute("data",userDto);
		return "user/popup";
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
	
	@GetMapping("/user/custom")
	public String customUserInfo(@AuthenticationPrincipal UserExtend user, Model model) {
		model.addAttribute("user", user);
		return "user/custom";
	}
	
	@PostMapping("/user/custom")
	public String customUserInfo2(UserVo userVo, Model model) {
		userService.updateUser(userVo);
		model.addAttribute("user", userVo);
		return "user/custom";
	}
}

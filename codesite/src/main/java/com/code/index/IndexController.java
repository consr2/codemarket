package com.code.index;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.code.security.UserExtend;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {

	
	
	
	@RequestMapping("/")
	public String index(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if(session == null) {
			request.getSession();
		}
		return "index";
	}
	
}

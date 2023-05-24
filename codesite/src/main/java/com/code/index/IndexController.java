package com.code.index;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.code.security.UserExtend;

@Controller
public class IndexController {

	
	
	
	@RequestMapping("/")
	public String index() {

		return "index";
	}
	
}

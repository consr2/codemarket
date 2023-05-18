package com.code.algorithm.compress;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CompressController {

	private final CompressService compressService;
	
	@GetMapping("/algorithm/compress")
	public String compress() {
		return "algorithm/compress";
	}
	
	@PostMapping("/algorithm/compress")
	public String compress(String str, Model model) {
		String result = compressService.compressString(str);
		String msg = compressService.compressMessage(str);
		
		model.addAttribute("msg", msg);
		model.addAttribute("str", str);
		model.addAttribute("result", result);
		return "algorithm/compress";
	}
}

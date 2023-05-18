package com.code.algorithm.bubble;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BubbleController {

	private final BubbleService bubbleService;
	
	
	@GetMapping("/algorithm/bubble")
	public String bubble() {
		return "algorithm/bubble";
	}
	
	@PostMapping("/algorithm/bubble")
	public String bubblesort(String value, Model model) {
		String message = bubbleService.valueCheck(value);
		Integer[] sort	= bubbleService.sortInt(value, message);
		
		model.addAttribute("value", value);
		model.addAttribute("sort", sort);
		model.addAttribute("message", message);
		return "algorithm/bubble";
	}
	
	
	
}

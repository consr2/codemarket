package com.code.market.bubble;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BubbleController {

	@Autowired
	private BubbleService bubbleService;
	
	
	@RequestMapping(value="/bubble", method = RequestMethod.GET)
	public String bubble() {
		return "bubble/bubble";
	}
	
	@RequestMapping(value="/bubble", method = RequestMethod.POST)
	public String bubblesort(String value, Model model) {
		String message = bubbleService.valueCheck(value);
		Integer[] sort	= bubbleService.sortInt(value, message);
		
		model.addAttribute("value", value);
		model.addAttribute("sort", sort);
		model.addAttribute("message", message);
		return "bubble/bubble";
	}

}

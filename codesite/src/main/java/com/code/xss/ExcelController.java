package com.code.xss;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ExcelController {

	private final ExcelService excelService;
	
	
	@RequestMapping("/xss")
	public String createXSS() {
		System.out.println("발송!");
		excelService.createXSS();
		return "redirect: ";
	}
}

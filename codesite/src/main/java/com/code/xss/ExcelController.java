package com.code.xss;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ExcelController {

	private final ExcelService excelService;
	
	
	@RequestMapping("/excel")
	public void createXSS(HttpServletResponse response) {
		excelService.createXSS(response);
		System.out.println("엑셀 다운로드");
	}
}

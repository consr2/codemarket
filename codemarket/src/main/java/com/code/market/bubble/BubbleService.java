package com.code.market.bubble;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class BubbleService {
	
	public String valueCheck(String value) {
		String message = "성공";
		if(value.equals("")) {
			message = "아무것도 입력하지 않았습니다.";
			return message;
		}
		boolean check = value.matches("^[0-9,]*$");
		if(check) {
			return message;
		}else {
			message = "입력값이 잘못되었습니다.";
			return message;
		}
	}

	public Integer[] getList(String numbers){
		String[] str = numbers.split(",");
		Integer[] li = new Integer[str.length];
		for(int i = 0; i < str.length; i++) {
			li[i] = Integer.parseInt(str[i]);
		}
		return li;
	}
	
	public Integer[] sortInt(String numbers, String check) {
		if(check.equals("성공")) {
			Integer[] li = getList(numbers);
			Integer box = 0;
			for(int i=0; i<li.length; i++) {
				for(int k=0; k<li.length-1; k++) {
					if(li[k] > li[k+1]) {
						box = li[k+1];
						li[k+1] = li[k];
						li[k] = box;
					}
				}
			}
			return li;
		}
		return new Integer[0];
	}
}

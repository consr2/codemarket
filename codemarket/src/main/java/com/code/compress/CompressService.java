package com.code.compress;

import org.springframework.stereotype.Service;

@Service
public class CompressService {
	
	public String compressString(String str) {
		String result = str;
		String temp = "";
		StringBuilder sb = new StringBuilder();
		
		//몇개씩 비교할 지
		for(int i = 1; i<= str.length() /2; i++) {
			int count = 1;
			
			//처음부터 끝까지 비교
			for(int k=i; k< str.length(); k += i) {
				//기준
				String standard = "";
				//비교할 대상
				String eql = "";
				int index = Math.min(k+i, str.length());

				standard = str.substring(k-i, k);
				eql = str.substring(k, index);
				
				//같으면 압축
				if(standard.equals(eql)) {
					count += 1;
					//문자열 끝이면 마무리
					if(k+i >= str.length()) {
						sb.append(standard);
						if(count != 1) {
							sb.append(count);
							count = 1;
						}
					}
				}else {
					sb.append(standard);
					if(count != 1) {
						sb.append(count);
						count = 1;
					}
					//마지막 문자열 추가
					if(index == str.length()) {
						sb.append(eql);
					}
				}
			}
			//길이 가장 짧은 것 리턴
			temp = sb.toString();
			result = (temp.length() < result.length()) ? temp : result;
			sb.setLength(0);
		}
		return result;
	}
	
	public String compressMessage(String str) {
		String msg = "";
		String level = "";
		String result = str;
		String temp = "";
		StringBuilder sb = new StringBuilder();
		//몇개씩 비교할 지
		for(int i = 1; i<= str.length() /2; i++) {
			int count = 1;
			
			//처음부터 끝까지 비교
			for(int k=i; k< str.length(); k += i) {
				//기준
				String standard = "";
				//비교할 대상
				String eql = "";
				int index = Math.min(k+i, str.length());

				standard = str.substring(k-i, k);
				eql = str.substring(k, index);
				
				//같으면 압축
				if(standard.equals(eql)) {
					count += 1;
					//문자열 끝이면 마무리
					if(k+i >= str.length()) {
						sb.append(standard);
						if(count != 1) {
							sb.append(count);
							count = 1;
						}
					}
				}else {
					sb.append(standard);
					if(count != 1) {
						sb.append(count);
						count = 1;
					}
					//마지막 문자열 추가
					if(index == str.length()) {
						sb.append(eql);
					}
				}
			}
			//길이 가장 짧은 것 리턴
			temp = sb.toString();
			if(temp.length() < result.length()) {
				result = temp;
				level = Integer.toString(i);
			}
			sb.setLength(0);
		}
		if(str.equals(result)) {
			msg = "길이가 같아 압축하지않았습니다.";
		}else{
			msg = level + " 묶음로 압축하였습니다.";
		}
		return msg;
	}

}

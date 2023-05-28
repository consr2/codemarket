package com.code.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.code.error.NaverError;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Service
public class NaverLoginService {
	
	@Value("${naver_client_id}")
	private String client_id;
	
	@Value("${naver_client_secret}")
	private String client_secret;
	
	//토큰 가져오기
	public Map<String, Object> getToken(HttpServletRequest request) throws NaverError{
	    String code = request.getParameter("code");
	    String state = request.getParameter("state");
	    String redirectURI = "";
		String apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code"
		        + "&client_id=" + client_id
		        + "&client_secret=" + client_secret
		        + "&redirect_uri=" + redirectURI
		        + "&code=" + code
		        + "&state=" + state;
		
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> result = new HashMap<>();
		try {
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.connect();
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {  // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
		    StringBuilder res = new StringBuilder();
		    while ((inputLine = br.readLine()) != null) {
		    	log.info(inputLine);
		    	res.append(inputLine);
		    }
		    br.close();
		    if (responseCode == 200) {
		    	result = objectMapper.readValue(res.toString(), new TypeReference<Map<String, Object>>() {});
		    	return result;
		    }else {
		    	throw new NaverError("네이버 아이디 조회 실패");
		    }
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		throw new NaverError("네이버 아이디 조회 실패");
	}
	
	//토큰으로 유저 정보 가져오기
	public Map<String, Object> getUserInfo(Map<String, Object> map) throws NaverError{
		String apiURL = "https://openapi.naver.com/v1/nid/me";
		String token = (String) map.get("access_token");
		
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> result = new HashMap<>();
		try {
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json");
	        con.setRequestProperty("Authorization", "Bearer " + token);
			con.connect();
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {  // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
		    StringBuilder res = new StringBuilder();
		    while ((inputLine = br.readLine()) != null) {
		    	log.info(inputLine);
		    	res.append(inputLine);
		    }
		    br.close();
		    if (responseCode == 200) {
		    	result = objectMapper.readValue(res.toString(), new TypeReference<Map<String, Object>>() {});
				return result;
		    }else {
		    	throw new NaverError("네이버 아이디 조회 실패");
		    }
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		throw new NaverError("네이버 아이디 조회 실패");
	}
	
	public UserDto getUserDto(Map<String, Object> map) {
		Map<String, Object> result = (Map<String, Object>) map.get("response");
		String username = (String) result.get("name");
		username += (String) result.get("nickname");
		String password = (String) result.get("id");
		
		UserDto userDto = new UserDto();
		userDto.setUsername(username);
		userDto.setPassword(password);
		
		return userDto;
	}
	
}

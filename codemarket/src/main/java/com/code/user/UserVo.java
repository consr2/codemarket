package com.code.user;

import java.util.Arrays;
import java.util.List;

import com.code.security.UserRole;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UserVo {

	private Long idx;
	private String username;
	private String password;
	private String nickname;
	private String role;
	
	@Builder
	public UserVo(String username, String password, String nickname) {
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.role = "GUEST";
	}

	public void upRole() {
		UserRole[] arr = UserRole.values();
		UserRole check = UserRole.valueOf(this.role);
		int idx = Arrays.asList(arr).indexOf(check);
		if(idx >= 1) {
			this.role = arr[idx-1].toString();
		}
	}
	
	public void downRole() {
		UserRole[] arr = UserRole.values();
		UserRole check = UserRole.valueOf(this.role);
		int idx = Arrays.asList(arr).indexOf(check);
		if(idx <= 1) {
			this.role = arr[idx+1].toString();
		}
	}
	
	
}

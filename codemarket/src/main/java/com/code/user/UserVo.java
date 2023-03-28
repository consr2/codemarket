package com.code.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
public class UserVo {

	private Long idx;
	private String username;
	private String password;
	private String role;
	
	@Builder
	public void saveUser(String username, String password) {
		this.username = username;
		this.password = password;
		this.role = "GUEST";
	}
	

	
	
}

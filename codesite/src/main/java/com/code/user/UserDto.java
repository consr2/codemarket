package com.code.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class UserDto {

	private Long idx;
	private String username;
	private String password;
	private String role;
	
	public UserDto(UserVo user) {
		this.idx = user.getIdx();
		this.username = user.getUsername();
		this.role = user.getRole();
	}
	
}

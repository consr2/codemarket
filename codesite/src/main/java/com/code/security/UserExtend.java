package com.code.security;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.code.user.UserVo;

import lombok.Getter;

@Getter
public class UserExtend extends User {

	private String username;
	private String nickname;
	
	public UserExtend(UserVo user, List<GrantedAuthority> authorities) {
		super(user.getUsername(), user.getPassword(), authorities);
		this.username = user.getUsername();
		this.nickname = user.getNickname();
	}
	

}

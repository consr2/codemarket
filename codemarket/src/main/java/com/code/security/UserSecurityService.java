package com.code.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.code.user.UserService;
import com.code.user.UserVo;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserSecurityService implements UserDetailsService{

	private final UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVo user = userService.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("유저 정보가 잘못되었습니다.");
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		String role = user.getRole();
		authorities.add(new SimpleGrantedAuthority(
				UserRole.valueOf(role).getValue()));
		
		return new User(user.getUsername(),user.getPassword(), authorities);
	}

}

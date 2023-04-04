package com.code.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.code.user.UserMapper;
import com.code.user.UserVo;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserSecurityService implements UserDetailsService{

	private final UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserVo> check = userMapper.findByUsername(username);
		if(check.isEmpty()) {
			throw new UsernameNotFoundException("유저 정보가 잘못되었습니다.");
		}
		UserVo user = check.get();
		List<GrantedAuthority> authorities = new ArrayList<>();
		String role = user.getRole();
		authorities.add(new SimpleGrantedAuthority(
				UserRole.valueOf(role).getValue()));
		
		return new User(user.getUsername(),user.getPassword(), authorities);
	}

}

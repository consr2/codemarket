package com.code.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	
	private final UserMapper userMapper;
	private final PasswordEncoder paswordEncoder;
	
	public List<UserVo> findAll() {
		List<UserVo> userList = userMapper.findAll();
		System.out.println(userList.toString());
		return userList;
	}
	
	public UserVo findByUsername(String username) {
		UserVo user = userMapper.findByUsername(username);
		return user;
	}

	public void save(UserDto userDto) {
		UserVo user = new UserVo();
		user.builder()
			.username(userDto.getUsername())
			.password(paswordEncoder.encode(userDto.getPassword()))
			.build();
		userMapper.save(user);
	}
}

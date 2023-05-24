package com.code.user;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.code.security.UserExtend;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	
	private final UserMapper userMapper;
	private final PasswordEncoder paswordEncoder;
	
	public List<UserDto> findAll() {
		List<UserVo> userList = userMapper.findAll();
		List<UserDto> collect = userList.stream().map(
				m -> new UserDto(m)).collect(Collectors.toList());
		return collect;
	}
	
	public UserDto findByUsername(String username) {
		Optional<UserVo> user = userMapper.findByUsername(username);
		if(user.isEmpty()) {
			return new UserDto();
		}
		return new UserDto(user.get());
	}

	public void save(UserDto userDto) {
		Optional<UserVo> check = userMapper.findByUsername(userDto.getUsername());
		if(check.isEmpty()) {
			UserVo user = UserVo.builder()
					.username(userDto.getUsername())
					.password(paswordEncoder.encode(userDto.getPassword()))
					.nickname("")
					.build();
			userMapper.save(user);
		}
	}
	
	public void deleteUser(Long idx) {
		userMapper.delete(idx);
	}

	public void upUser(Long id) {
		UserVo user = userMapper.findById(id).get();
		user.upRole();
		userMapper.updateRole(user);
	}
	
	public void downUser(Long id) {
		UserVo user = userMapper.findById(id).get();
		user.downRole();
		userMapper.updateRole(user);
	}

	public void updateUser(UserVo userVo) {
		userMapper.updateNickname(userVo);
	}

	

}

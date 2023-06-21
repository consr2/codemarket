package com.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.code.user.UserDto;
import com.code.user.UserService;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
class CodemarketApplicationTests {

	@Autowired
	private UserService userService;
	
	@Test
	void duplicateUserTest() {
	    UserDto user1 = new UserDto();
	    user1.setUsername("test");
	    user1.setPassword("asdf");
	    userService.save(user1);
	    
	    UserDto user2 = new UserDto();
	    user2.setUsername("test");
	    user2.setPassword("asdf");
	    String message = userService.save(user1);
	    
	    assertEquals(message, "중복입니다");
	}

}

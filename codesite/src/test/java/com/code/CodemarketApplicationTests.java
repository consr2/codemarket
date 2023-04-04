package com.code;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.code.user.UserMapper;

@SpringBootTest
@Transactional
class CodemarketApplicationTests {

	@Autowired UserMapper userMapper;
	
	@Test
	void contextLoads() {
		
	}

}

package com.code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CodemarketApplicationTests {

	@Test
	void contextLoads() {
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/codemarket","root","1234");
			
			System.out.println(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

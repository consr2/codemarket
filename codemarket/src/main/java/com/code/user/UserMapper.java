package com.code.user;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
	
	@Select("select * from users")
	List<UserVo> findAll();
	
	@Select("select * from users where username = #{username}")
	UserVo findByUsername(@Param("username") String username);
	
	@Insert("insert into users(username, password, role) values"
			+ "(#{user.username},#{user.password}, #{user.role})")
	void save(@Param("user")UserVo user);

}

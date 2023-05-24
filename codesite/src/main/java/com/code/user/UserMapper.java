package com.code.user;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
	
	@Select("select * from users")
	List<UserVo> findAll();
	
	@Select("select * from users where idx = #{idx}")
	Optional<UserVo> findById(@Param("idx")Long idx);
	
	@Select("select * from users where username = #{username}")
	Optional<UserVo> findByUsername(@Param("username") String username);
	
	@Insert("insert into users(username, password, role, nickname) values"
			+ "(#{user.username},#{user.password}, #{user.role}, #{user.nickname})")
	void save(@Param("user")UserVo user);

	@Delete("delete from users where idx = ${idx}")
	void delete(@Param("idx")Long idx);

	@Update("update users set role = #{user.role} where idx = #{user.idx}")
	void updateRole(@Param("user")UserVo user);
	
	void updateNickname(UserVo userVo);

}

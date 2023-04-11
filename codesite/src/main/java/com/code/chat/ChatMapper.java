package com.code.chat;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ChatMapper {

	@Select("select * from chatroom")
	List<ChatRoomVo> findAll();

	@Insert("insert into chatroom(room_name, host, max_member) values (#{vo.roomName}, #{vo.host}, #{vo.maxMember})")
	void save(@Param("vo")ChatRoomVo vo);

	@Delete("delete from chatroom where idx = #{idx}")
	void delete(@Param("idx")Long idx);

	@Select("select * from chatroom where idx = #{idx}")
	ChatRoomVo findById(@Param("idx")Long idx);

}

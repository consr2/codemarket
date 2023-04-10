package com.code.chat;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ChatMapper {

	@Select("select * from chatroom")
	List<ChatRoomVo> findAll();

	@Insert("insert into chatroom(room_name) values (#{vo.roomName})")
	void save(@Param("vo")ChatRoomVo vo);

}

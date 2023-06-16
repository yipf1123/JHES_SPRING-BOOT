package com.study.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.springboot.dto.UserDTO;

@Mapper
public interface UserDAO {
	
	int insertUser(String id);
	List selectUser();
	int updateUser(String name);
	int deleteUser(UserDTO userDTO);
	
	
	int joinUser(UserDTO userDTO);
	int loginCheck(UserDTO userDTO);
	int idCheck(UserDTO userDTO);
	
	UserDTO selectUserInfo(UserDTO userDTO);
}

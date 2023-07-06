package com.study.springboot.service;

import java.util.List;
import java.util.Map;

import com.study.springboot.dto.UserDTO;

public interface UserService {

	int setUser(String id);
	List getUser();
	int modifyUser(String name);
	int deleteUser(UserDTO dto);
	
	int joinUser(UserDTO dto);
	Map loginCheck(UserDTO dto);
	
}

package com.study.springboot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.common.Const;
import com.study.springboot.dao.UserDAO;
import com.study.springboot.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO userDAO;
	
	@Override
	public int setUser(String id) {
		
		int result = userDAO.insertUser(id);
		
		return 0;
	}
	
	@Override
	public List getUser() {
		List list = userDAO.selectUser();
		return list;
	}

	@Override
	public int modifyUser(String name) {
		int result = userDAO.updateUser(name);
		return result;
	}

	@Override
	public int deleteUser(UserDTO dto) {
		int result = userDAO.deleteUser(dto);
		return result;
	}

	@Override
	public int joinUser(UserDTO dto) {
		int result = -1;
	
		final int CODE_JOIN_DUP_ID = -1; // 아이디 중복
		
		// id가 이미 있는지 검사
		int countId = userDAO.idCheck(dto);
		
		if (countId == 0) {
			//id가 중복되지 않음
			result = userDAO.joinUser(dto);
			// result에는 1(insert 성공)
		}else {
			// id가 이미 존재한다면
			result = Const.CODE_JOIN_DUP_ID;
		}
		return result;
	}

	@Override
	public Map loginCheck(UserDTO dto) {
		int result = userDAO.loginCheck(dto);
		UserDTO dto2 = userDAO.selectUserInfo(dto);
		
		Map map = new HashMap(); 
		map.put("count", result);
		map.put("dto", dto2);
		return map;
	}



}

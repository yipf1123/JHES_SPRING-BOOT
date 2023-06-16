package com.study.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.springboot.dto.TodoDTO;
import com.study.springboot.dto.UserDTO;

@Mapper
public interface TodoDAO {
	
	int insertTodo(TodoDTO dto);
	
	List<TodoDTO> selectTodo();
	
}

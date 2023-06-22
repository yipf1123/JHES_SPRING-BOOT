package com.study.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.springboot.dto.TodoDTO;
import com.study.springboot.dto.UserDTO;

@Mapper
public interface TodoDAO {
	
	int insertTodo(TodoDTO dto);
	
	List<TodoDTO> selectTodo(TodoDTO dto);
	
	TodoDTO detailTodo (int todo_id);
	
	int updateTodo(TodoDTO todoDTO);
	int deleteTodo(TodoDTO todoDTO);
	
	int totalCount();
	
}

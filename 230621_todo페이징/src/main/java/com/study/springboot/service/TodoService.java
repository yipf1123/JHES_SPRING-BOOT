package com.study.springboot.service;

import java.util.List;
import java.util.Map;

import com.study.springboot.dto.TodoDTO;


public interface TodoService {

	int addTodo(TodoDTO dto);
	Map list(TodoDTO dto);
	
	TodoDTO detailTodo (int todo_id);

	int updateTodo(TodoDTO todoDTO);
	int deleteTodo(TodoDTO todoDTO);
}


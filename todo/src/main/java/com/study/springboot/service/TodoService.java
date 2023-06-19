package com.study.springboot.service;

import java.util.List;

import com.study.springboot.dto.TodoDTO;


public interface TodoService {

	int addTodo(TodoDTO dto);
	List<TodoDTO> list();
	
	TodoDTO detailTodo (int todo_id);

	int updateTodo(TodoDTO todoDTO);
	int deleteTodo(TodoDTO todoDTO);
}

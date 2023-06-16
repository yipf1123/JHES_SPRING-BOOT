package com.study.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.dao.TodoDAO;
import com.study.springboot.dto.TodoDTO;

@Service
public class TodoServiceImpl implements TodoService{

	@Autowired
	TodoDAO todoDAO;
	
	@Override
	public int addTodo(TodoDTO dto) {
		
		int result = todoDAO.insertTodo(dto);
		
		return result;
	}

	@Override
	public List<TodoDTO> list() {
		List<TodoDTO> list = todoDAO.selectTodo();
		return list;
	}


}

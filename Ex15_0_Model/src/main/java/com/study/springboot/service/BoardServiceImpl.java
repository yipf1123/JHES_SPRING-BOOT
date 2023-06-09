package com.study.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.dao.BoardDAO;
import com.study.springboot.dao.BoardDAOImpl;

@Service
public class BoardServiceImpl implements BoardService{

	//3. 자동으로 생성되게 변경 
	@Autowired	// 자동주입 어노테이션
	BoardDAO bd;
	
	//2. 필드로 옮김
//	BoardDAO bd =  new BoardDAOImpl();
	
	
	public List getList() {
		List listBoard = null;
		
		// 1. 클래스 직접 생성
//		BoardDAO bd =  new BoardDAOImpl();
		listBoard = bd.selectList();
		
		return listBoard;
	}
}

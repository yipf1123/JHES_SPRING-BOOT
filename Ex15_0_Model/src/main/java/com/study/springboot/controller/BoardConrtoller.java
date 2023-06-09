package com.study.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.dao.BoardDAOImpl;
import com.study.springboot.service.BoardService;
import com.study.springboot.service.BoardServiceImpl;

@Controller
public class BoardConrtoller {
	
	@Autowired
	BoardService boardService;

	@RequestMapping("/board1")
	public String read(Model model) {

		
		// DB 접속해서 게시판의 글을 가져오고
		
		// 직접구현
//		List listBoard = new ArrayList();
//		listBoard.add("일");
//		listBoard.add("이");
//		listBoard.add("삼");
//
//		System.out.println("두번째값 : " + listBoard.get(1));
//		
		
		// BoardDAOImpl에서 구현
//		List listBoard = null;
//		
//		BoardDAOImpl bd =  new BoardDAOImpl();
//		listBoard = bd.selectList();
			
		// BoardServiceImpl에서 구현
		List listBoard = null;
//		BoardServiceImpl bs =new BoardServiceImpl();
		listBoard = boardService.getList();
		
		// 가져온 내용을 jsp로 보낸다
		model.addAttribute("listBoard", listBoard);
		
		return "result";
	}
}

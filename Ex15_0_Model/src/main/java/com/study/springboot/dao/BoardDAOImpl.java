package com.study.springboot.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Override // 부모(BoardDAO)에 이 메소드가 있는지 체크해주는 기능
	public List selectList() {
		// DB 접속해서 게시판의 글을 가져오고
		List listBoard = new ArrayList();
		listBoard.add("일");
		listBoard.add("이");
		listBoard.add("삼");

		System.out.println("두번째값 : " + listBoard.get(1));
		
		return listBoard;
	}

}

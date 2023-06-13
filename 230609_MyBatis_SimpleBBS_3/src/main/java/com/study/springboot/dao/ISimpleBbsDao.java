package com.study.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.springboot.dto.SimpleBbsDto;

@Mapper
public interface ISimpleBbsDao {
	
	List listDao();
	SimpleBbsDto viewDao(String id);
	
	// return값인 int 실행 결과 영향을 받은 row 수 
	// select 이외는 int로 받음
	int writeDao(String writer, String title, String content);
	int deletDao();
	int updateDao(String writer, String title, String content, int id);
	
}

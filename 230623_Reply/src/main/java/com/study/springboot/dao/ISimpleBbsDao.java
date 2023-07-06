package com.study.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import com.study.springboot.dto.SimpleBbsDto;

@Mapper
public interface ISimpleBbsDao {
	
	public abstract List<SimpleBbsDto> listDao();
	
	SimpleBbsDto viewDao(String id);
	
	// return값인 int는 실행 결과 영향을 받은 row 수
	int writeDao(SimpleBbsDto dto);
	
	int deleteDao(String id);
	int updateDao(SimpleBbsDto dto);
	
	List testIf(SimpleBbsDto dto);
	
	List testForeach(SimpleBbsDto dto);
}

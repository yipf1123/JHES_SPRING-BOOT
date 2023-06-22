package com.study.springboot.dao;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.springboot.dto.MakeItDto;

@Mapper
public interface I_MakeItDao {
	
	List listMI();
	List listMI_day(Date day);
	List listMI_today();
	
	/* List listMI_today(); */
	int writeMI(MakeItDto dto);
	int deleteMI(String id);
	int updateMI(MakeItDto dto);
	
	List testForeach(MakeItDto dto);
	
}

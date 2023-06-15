package com.study.springboot.dao;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.springboot.dto.MakeItDto;

@Mapper
public interface I_MakeItDao {
	
	List listMI();
	List listMI_day(LocalDate day);
	List listMI_today();
	
	/* List listMI_today(); */
	int writeMI(MakeItDto dto);
	int deleteMI(String id);
	int updateMI();
	
	List testForeach(MakeItDto dto);
	
}

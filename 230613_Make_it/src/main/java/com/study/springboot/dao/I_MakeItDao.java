package com.study.springboot.dao;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface I_MakeItDao {
	List listMI();

	/* List listMI_today(); */
	int writeMI(String id, LocalDate day, String category, String toDO);
	int deleteMI();
	int updateMI();
	
}

package com.study.springboot.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Transaction1Dao {

	int pay(String consumerId, String amount);
	
}


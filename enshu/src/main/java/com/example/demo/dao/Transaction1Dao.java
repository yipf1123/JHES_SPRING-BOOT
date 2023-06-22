package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Transaction1Dao {

	int pay(String consumerid, String amount);
	
}

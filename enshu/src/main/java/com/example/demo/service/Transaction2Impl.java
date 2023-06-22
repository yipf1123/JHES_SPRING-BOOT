package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Transaction2Dao;

@Service
public class Transaction2Impl implements Transaction2Service {

	@Autowired
	Transaction2Dao trans2Dao;
	
	
	@Override
	public int pay(String consumerid, String amount) {
		
		int result = trans2Dao.pay(consumerid, amount);
		
		return result;
	}

}

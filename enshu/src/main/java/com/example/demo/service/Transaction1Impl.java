package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Transaction1Dao;

@Service
public class Transaction1Impl implements Transaction1Service {

	@Autowired
	Transaction1Dao tran1Dao;
	 
	
	@Override
	public int pay(String consumerid, String amount) {
		int result = tran1Dao.pay(consumerid, amount);
		return result;
	}

}

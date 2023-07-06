package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.Transaction1Service;
import com.example.demo.service.Transaction2Service;

@Controller
public class MyController {
	
	@Autowired Transaction1Service trans1Service;
	@Autowired Transaction2Service trans2Service;
	
	
	@RequestMapping("/buy_ticket_card")
	@ResponseBody
	public String buy_ticket_card(
			@RequestParam("consumerId") String consumerId,
			@RequestParam("amount") String amount,
			@RequestParam("error") String error
			
			) {
		
		int result1 = trans1Service.pay(consumerId, amount);
		System.out.println("resul1 :" + result1);
		int result2 = trans2Service.pay(consumerId, amount);
		// TODO
		// DAO - DAO 연결완료
		// DAO - Service
		// Service - Controller
		// 전달인자 consumerId, amount를 DB insert
			
		
		return "Done";
	}
	
}

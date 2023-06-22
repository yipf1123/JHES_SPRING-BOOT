package com.study.springboot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.service.BuyTicketService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {
	
	@Autowired
	BuyTicketService buyTicketService;

	@RequestMapping("/buy_ticket_card")
	@ResponseBody
	public String buy_ticket_card(
			@RequestParam("consumerId") String consumerId,
			@RequestParam("amount") String amount,
			@RequestParam("error") String error,
			HttpServletRequest request
	) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// TODO
		// xml - DAO 연결 [완료]
		// DAO - Service
		// Service - Controller
		
		// 전달인자 consumerId, amount를 DB에 insert
		int result = buyTicketService.buy(consumerId, amount, error);
		System.out.println("result : "+ result);
		
		return "Done";
	}
}

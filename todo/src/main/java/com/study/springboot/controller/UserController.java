package com.study.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.springboot.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	
	@RequestMapping("/")
	public String login(@RequestParam("a") String a,
			Model model) {
		
		System.out.println("hello world : " + a);
		
		model.addAttribute("han", a);
	
		return "user/login";
	} 
	
	@RequestMapping("/test/insert")
	public String testInsert(@RequestParam("id") String id) {
		int result = userService.setUser(id);
		System.out.println("insert 결과" + result);
		return "user/login";
	}
}

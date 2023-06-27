package com.study.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TilesController {

	@RequestMapping("/test1")
	public String test1() {
		System.out.println("여기는/test1");
		return"viewList";
	}
	
	@RequestMapping("/test2")
	public String test2() {
		System.out.println("여기는 /test2");
		
		return "viewList2";
	}
		
}



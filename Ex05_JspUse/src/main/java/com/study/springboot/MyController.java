package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	// 다 같은 test1이 아니다
	@RequestMapping("/test1") // URL
	public String test1() { // 메소드 이름
		System.out.println("/test1 진입 완료"); //console에 표기 됨
		return "test1"; // JSP 이름
	}
	
	@RequestMapping("/test2")
	public String test2() {
		System.out.println("/test2 진입 완료");
		String nextPage = "sub/test2";
		
		return nextPage;
	}
	
	@RequestMapping("/enshu")
	@ResponseBody // 반환값이 View Resolver를 거치지 않고 나와 문자열로 표현
	public String enshu() {
		System.out.println("/enshu 진입 완료");
		return "{'key1':'value1', 'key2':'value2'}";
	}
	
	@RequestMapping("/ajax")
	public String ajax() {
		System.out.println("/ajax 진입 완료");
		return "ajax";
	}
}



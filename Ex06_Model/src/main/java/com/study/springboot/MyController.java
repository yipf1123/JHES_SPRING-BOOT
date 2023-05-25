package com.study.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	@RequestMapping("/test1")
	public String test1(Model model) {
		model.addAttribute("name", "이은솔"); // ${name}
		model.addAttribute("adress", "부천시");
		return "test1";
	}
	
	@RequestMapping("/mv")
	public ModelAndView test2() {
		ModelAndView mv = new ModelAndView();
											//생성자에 jsp 파일명을 지정	
		// ModelAndView mv = new ModelAndView("view/myView");
		
		
		List<String> list = new ArrayList();
		
		list.add("test1");
		list.add("test2");
		list.add("test3");
		
		mv.addObject("lists", list);					// jstl로 호출
		mv.addObject("ObjectTest", "테스트입니다.");   // jstl로 호출
		mv.addObject("name", "홍길동");              // jstl로 호출
	
		// jsp 파일명을 지정
		mv.setViewName("view/myView");
		
		return mv;
	}
	
	@RequestMapping("/el")
	public String el() {
		return"el";
	}
	
	@RequestMapping("/jstl")
	public String jstl() {
		return"jstl";
	}
	
	@RequestMapping("/gugu")
	public String gugu() {
		return"gugu";
	}
	
	@RequestMapping("/gugu9")
	public String gugu9() {
		return"gugu9";
	}
	
}

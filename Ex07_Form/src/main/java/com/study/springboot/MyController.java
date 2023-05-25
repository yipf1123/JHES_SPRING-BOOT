package com.study.springboot;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {

	// 전달 받은 id, name 값을 받아서 jsp로 보낸다
	@RequestMapping("/test1")
	public String test1(HttpServletRequest httpServeletRequest, Model model) {

		// 전달받은 파라미터 중에 key가 id인 것의 value를 가져온다
		// key가 없다면 null을 return한다.
		String id = httpServeletRequest.getParameter("id");
		String name = httpServeletRequest.getParameter("name");

		model.addAttribute("id", id);
		model.addAttribute("name", name);

		return "test1";

	}

	// 전달인자에 어노테이션을 이용해서 바로 받기
	@RequestMapping("/test2")
	public String test2(Model model,
			// String id = httpServeletRequest.getParameter("id");
			// 이 역할을 해줌
			// 파라미터 중에 id가 없는 경우에는
			// 실행되지 않도록 해줌
			@RequestParam("id") // key 필수 값 : 없으면 400코드
			String id,

//			@RequestParam("name")
			@RequestParam(value = "name", required = false) // key가 없어도 사용가능
			String name,

			// 넘겨 받은 모든 것을 map에 저장
			@RequestParam Map map

	) {
		map.get("id");
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		// 책에는 test2로 되어있지만 굳이...
		return "test1";

	}

	@RequestMapping("/test3")
	public String test3(Model model,
			/*
			 * @ModelAttribute 전달받은 key와 클래스의 필드명이 같은 경우 ("set" + 전달받은 key의 첫글자를 대문자로하는 메소드를
			 * 실행 자동으로 값을 채운다
			 * 
			 * 뒤에 나오는 괄호안의 key로 model에 넣어준다 단, key와 변수명이 같은경우 어노테이션을 생략 가능
			 */
			@ModelAttribute("memberDTO") MemberDTO memberDTO) {
		String id = memberDTO.getId();
		System.out.println("id : " + id);

		model.addAttribute("member2", memberDTO);
		// @ModelAttribute만 있었다면 직접 model에 넣어줘야 한다.
		model.addAttribute("memberDTO", memberDTO);
		return "test3";
	}
	
	@RequestMapping("/test4/{studentId}/{name}")
	public String getStudent(
			@PathVariable String studentId,
			@PathVariable String name,
			Model model
			) {
		
		model.addAttribute("id", studentId);
		model.addAttribute("name",name);
		
		return "test1";
		
		
		
	}
			
	
	

}

package com.study.springboot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ShopController {
	
	List<String> list = new ArrayList();// 위치가 포인트, id 값을 기록 남기기

	/*
	 * 브라우저에 전달한 값을 출력만
	 */
	@RequestMapping("/send1") // 모든 method를 받을 수 있음
	// @RequestMapping(value="/send1") // 위와 같음
	// @RequestMapping(value="/send1", method=RequestMethod.GET)
	// @GetMapping("/send1")// 위와 같음
	// @RequestMapping(value="/send1", method={RequestMethod.GET,RequestMethod.POST})
	// get이 아닌 method로 들어오면 405 method not allowed
	// @PostMapping("/send1")
	public String print(
				HttpServletRequest request, // 인터넷과 자바를 연결하는 
				
				// 들어올 때 필수; 없으면 400 bad request @:메소드
				@RequestParam("id") String id2,
				
				// 필수 아님; 없으면 null 이 들어감 (""과 비교하여 알아두셈)
				@RequestParam(value= "id", required=false) String id3,
			
				Model model
			) {

		// id에 해당하는 내용을 전달받아 
		// 변수에 저장한다
		
		
		// HttpServletRequest request 와 짝꿍으로 쓰는 것
		// 전달받은 key값 중에서 여러개 중 첫번째것 하나만 가져옴
		String id = request.getParameter("id"); // querySelector 처럼
		// 전달받은 key값 일치한 모두를 가져옴
		String[] ids = request.getParameterValues("id"); // querySelectorAll 처럼
		
	
		System.out.println("id :" + id);
		System.out.println("id2 :" + id2);
		System.out.println("id3 :" + id3);
		for(String value :ids) {
			System.out.println("ids : " + value);
			
		}
		// 위는  콘솔창에 뜨는 파트
		////////////////////////////////////////////////////////////////////////////
		// jsp 내보내기
		
		model.addAttribute("req_id", id ); // jsp로 보내는 친구
		
		list.add(id);// id 값을 기록 남기기
		model.addAttribute("list_id", list); 
		for(int i=0; i<list.size(); i++) {
			System.out.println(i + "번째 id : " + list.get(i));
		}
		
		
		
		request.setAttribute("req_id2", id);
		request.setAttribute("text", "abcd");
		request.setAttribute("m", "model");
		
		
		String  req_id2 = (String)request.getAttribute("req_id2");
		System.out.println("req_id2 : " + req_id2);
		
	
		
		return "view";
	}
	
	@RequestMapping("/input")
	public String input() {
		
		
		return "input";
	}
	
	@ResponseBody
	@RequestMapping("/api/getBagList")
	public List getBagList() {
		List list_item = new ArrayList();
		
		Map info = new HashMap();
		info.put("img_src", "//image.msscdn.net/images/goods_img/20230401/3199783/3199783_16844763299344_320.jpg");
		info.put("name", "보테가베네타");
		info.put("desc", "여성 카세트 크로스백 - 페러킷");
		info.put("price", "1,380,000");
		
		list_item.add(info);
		list_item.add(info);
		list_item.add(info);
	
		return list_item;
	}
	
	
	

}

package com.study.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.springboot.dao.I_MakeItDao;
import com.study.springboot.dto.MakeItDto;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {
	@Autowired
	I_MakeItDao dao;
	
	
	@RequestMapping("/login")
	public String login() {
		System.out.println("login 접속완료");
		return "login";
	}

	@RequestMapping("/loginCheck")
	public String loginCheck(HttpServletRequest req) {
		System.out.println("loginCheck 접속완료");
		//세션 테스트
		HttpSession session = req.getSession();
		session.setAttribute("isLogon", true);
		return "redirect:/list";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest req) {
		System.out.println("logout 접속완료");
		HttpSession session = req.getSession();
		session.invalidate();
		return "login";
	}
	
	@RequestMapping("/list")
	public String userlistPage(Model model,
			HttpServletRequest req) {
		System.out.println("list 접속완료");
		
		List list = dao.listMI();
		System.out.println(list.size());
		model.addAttribute("list", list);
		
		
		return "list";
	}
	
	
	@RequestMapping("/serchM")
	public String serchMonth(Model model,
			@ModelAttribute MakeItDto dto) {
		System.out.println("serchM 접속완료");
		return "list";
	}
	
	@RequestMapping("/today")
	public String today(Model model) {
		List list = dao.listMI_today();
		model.addAttribute("list", list);
		return "today";
	}
	
	@RequestMapping("/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	
	
	@RequestMapping("/write")
	public String write(Model model, 
			@ModelAttribute MakeItDto dto) {
		System.out.println("write 접속완료");
//		System.out.println(dto.getDay());
//		System.out.println(dto.getCategory());
//		System.out.println(dto.getToDo());
		int result = dao.writeMI(dto);

		return "redirect:/dayform?day=" + dto.getDay();
	}
	
	
	@RequestMapping("/dayform")
	public String dayform(Model model, 
			@ModelAttribute MakeItDto dto) {
		System.out.println("dayform 접속완료");

		System.out.println(dto.getDay());
		List list = dao.listMI_day(dto.getDay());
		model.addAttribute("list", list);
		
		model.addAttribute("day", dto.getDay());
	
		return "writeForm";
	}
	
	
	
	@RequestMapping("/delete")
	public String delete(
			@ModelAttribute MakeItDto dto,
			Model model) {
	System.out.println("delete 접속완료");
	System.out.println(dto.getDo_id());
	int result = dao.deleteMI(""+dto.getDo_id());
	System.out.println("삭제 개수 : " + result);
	
	return "redirect:/dayform?day=" + dto.getDay();
	}
	


}

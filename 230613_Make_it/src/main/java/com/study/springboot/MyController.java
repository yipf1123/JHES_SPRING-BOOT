package com.study.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
	@RequestMapping("/write")
	@RequestMapping("/testForeach")
	
	
	


}

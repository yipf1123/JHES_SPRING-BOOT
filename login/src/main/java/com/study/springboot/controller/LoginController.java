package com.study.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	@RequestMapping("/login")

	public String login() {
		System.out.println("안녕");
		return "login";
	}

	@RequestMapping("/mypage")
	public String mypage(HttpServletRequest request, Model model) {
		String nextPage = "login";

		// 세션 가져오기
		HttpSession session = request.getSession();

		// 세션에 저장
		String id = (String) session.getAttribute("isLogin2");
		System.out.println("id : " + id);
		if (id != null) {
			model.addAttribute("id", id);
			nextPage = "mypage";
		} else {
			session.setAttribute("msg", "회원이 아닙니다.");
		}
		return nextPage;
	}

	@RequestMapping("/login_check")
	public String login_check(HttpServletRequest request, 
			/*
			 * @RequestParam("pw") String pw,
			 * 
			 * @RequestParam("id") String id,
			 */
			Model model)

	{
		String nextPage = null;
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		String _id = "admin";
		String _pw = "1234";
		HttpSession session = request.getSession();
		if (id != null && pw != null) {
			if (id.equals(_id) && pw.equals(_pw)) {
				// 로그인 확인 완료

				// 세션 가져오기
				

				// 세션 저장하기
				session.setAttribute("isLogin2", id);
				model.addAttribute("id", id);
				nextPage = "/mypage";

			} else {
				// 회원정보 없음
				
				session.setAttribute("msg", "회원이 아닙니다.");
				nextPage = "/login";
			}
		} else {
			
			session.setAttribute("msg", "아이디와 패스워드는 필수 입니다.");
			nextPage = "/login?msg";
		}

		return "redirect:" + nextPage;
		// redirect는 페이지를 신규로 받는거라 model이 유지가 안됨.
	}

}

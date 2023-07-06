package com.study.springboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.common.Const;
import com.study.springboot.dao.UserDAO;
import com.study.springboot.dto.UserDTO;
import com.study.springboot.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	UserDAO userDAO;
	
	@RequestMapping("/")
	public String login(
//			@RequestParam("a") String a,
			Model model) {

		System.out.println("hello world : ");

//		model.addAttribute("han", a);

		return "user/login";
	}

	@RequestMapping("/test/insert")
	public String testInsert(@RequestParam("id") String id) {
		int result = userService.setUser(id);
		System.out.println("insert 결과" + result);
		return "user/login";
	}

	@RequestMapping("/test/list")
	public String testList() {
		List list = userService.getUser();
		System.out.println("list 결과" + list);
//		list 결과  : com.study.springboot.dto.userDTO@fklajfoijadjlkj12 (toString전)
		return "user/login";
	}

	@RequestMapping("/test/update")
	public String testUpdate(HttpServletRequest req) {
		String name = req.getParameter("name");
		System.out.println("name : " + name);

		int result = userService.modifyUser(name);
		System.out.println("update 결과" + result);

		return "user/login";
	}

	@RequestMapping("/test/delete")
	public String testDelete(@ModelAttribute UserDTO userDTO, Model model) {
		System.out.println("userDTO.getName()" + userDTO.getName());

		int result = userService.deleteUser(userDTO);
		System.out.println("delete 결과" + result);
		return "user/login";
	}

	@RequestMapping("/joinForm")
	public String joinFrom() {
		return "user/joinForm";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute UserDTO userDTO, Model model) {

		int result = userService.joinUser(userDTO);
		System.out.println("joinUser 결과" + result);

		if (result == Const.CODE_JOIN_DUP_ID) {
			model.addAttribute("msg", "이미 사용중인 아이디 입니다.");
			return "user/joinForm";
		}

		return "user/login";
	}
	
	@RequestMapping(value="/api/todo",method=RequestMethod.POST)
	@ResponseBody
	public int idCheck(
			@RequestBody
			UserDTO userDTO	
			) {
		System.out.println("[POST] /api/todo userDTO.getId() :" + userDTO.getId());
		
		int countId = userDAO.idCheck(userDTO);
		
		return countId;
	}

	@RequestMapping("/loginForm")
	public String loginForm() {
		return "user/login";
	}

	@RequestMapping("/login")
	public String login(@ModelAttribute UserDTO userDTO, Model model, HttpServletRequest req) {

		System.out.println("/login" + userDTO);

		Map result = userService.loginCheck(userDTO);
		int count = (int) result.get("count");
		UserDTO dto = (UserDTO) result.get("dto");

		
		System.out.println("count" + result);
		System.out.println("dto" + dto);

		if (count != 0) {
			// 계정 있음
			HttpSession session = req.getSession();
			session.setAttribute("login", "ok");
			if(dto != null) {
			session.setAttribute("user_id", dto.getUser_id());}
		} else {
			// 계정 없음
			model.addAttribute("msg", "계정을 확인해주세요");
		}

		return "redirect:/list.do";
	}

}

package com.study.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.springboot.dto.TodoDTO;
import com.study.springboot.service.TodoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class TodoController {
	
		@Autowired
		TodoService todoService;
	
		@RequestMapping(value="/add.do", method=RequestMethod.GET)
		public String addPage(HttpServletRequest req) {
			
			String page = "user/login";
		
			
			HttpSession session = req.getSession();
			
			//로그인 상태 점검
			String login = (String)session.getAttribute("login");
			if(login == null || !"ok".equals(login)) {
				page = "user/login";
			}else {
				page="todo/add";
			}
			
			return page;
		}

		@RequestMapping(value="/add", method=RequestMethod.POST)
		public String add(@ModelAttribute
				TodoDTO todoDTO,
				HttpServletRequest req) {
			HttpSession session = req.getSession();
			
			//로그인 상태 점검
			String login = (String)session.getAttribute("login");
			if(login == null || !"ok".equals(login)) {
				return "user/login";
			}
			
			System.out.println("todo : " + todoDTO.getTodo());
			System.out.println("due_date : " + todoDTO.getDue_date());
			
			int user_id =(int) session.getAttribute("user_id");
			System.out.println("user_id : " + user_id);
			todoDTO.setUser_id(user_id);
			
			
			int result = todoService.addTodo(todoDTO);
			System.out.println("할 일 추가 결과" + result);
			
			
			return "todo/add";
		}

		
		@RequestMapping("/list.do")
		public String list(Model model) {
			
			List<TodoDTO> list = todoService.list();
			model.addAttribute("list", list);
			
			return "todo/list";
		}
		
}

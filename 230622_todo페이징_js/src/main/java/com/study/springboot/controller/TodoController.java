package com.study.springboot.controller;

import java.util.HashMap;
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

import com.study.springboot.dto.TodoDTO;
import com.study.springboot.service.TodoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class TodoController {

	@Autowired
	TodoService todoService;

	@RequestMapping(value = "/add.do", method = RequestMethod.GET)
	public String addPage(HttpServletRequest req) {

		String page = "user/login";

		HttpSession session = req.getSession();

		// 로그인 상태 점검
		String login = (String) session.getAttribute("login");
		if (login == null || !"ok".equals(login)) {
			page = "user/login";
		} else {
			page = "todo/add";
		}

		return page;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute TodoDTO todoDTO, HttpServletRequest req) {
		HttpSession session = req.getSession();

		// 로그인 상태 점검
		String login = (String) session.getAttribute("login");
		if (login == null || !"ok".equals(login)) {
			return "user/login";
		}

		System.out.println("todo : " + todoDTO.getTodo());
		System.out.println("due_date : " + todoDTO.getDue_date());

		int user_id = (int) session.getAttribute("user_id");
		System.out.println("user_id : " + user_id);
		todoDTO.setUser_id(user_id);

		int result = todoService.addTodo(todoDTO);
		System.out.println("할 일 추가 결과" + result);

		return "redirect:/list.do";
	}

	@RequestMapping("/list_csr.do")
	public String list_csr() {

		return "todo/list_csr";
	}

	@RequestMapping(value = "/api/todo", method = RequestMethod.GET)
	@ResponseBody
	public Map todoList(
			Model model, 
			@RequestParam(value = "pageNum", required = false) Integer pageNum,
			HttpServletRequest req
		) {

		TodoDTO todoDTO = new TodoDTO();

		if (pageNum == null) {
			pageNum = 1;
		}
		System.out.println("pageNum : " + pageNum);

		String cpp = req.getParameter("countPerpage");
		int countPerpage = 10;
		try {
			countPerpage = Integer.parseInt(cpp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		int startNum = ((pageNum - 1) * countPerpage) + 1;
		int endNum = startNum + (countPerpage - 1);

		todoDTO.setStartNum(startNum);
		todoDTO.setEndNum(endNum);

		Map map = todoService.list(todoDTO);

		List<TodoDTO> list = (List<TodoDTO>) map.get("list");

		int total = (int) map.get("totalCount");


		Map returnMap = new HashMap();
		returnMap.put("pageNum", pageNum);
		returnMap.put("countPerpage", countPerpage);
		returnMap.put("list", list);
		returnMap.put("total", total);
		
		return returnMap;
	}

	@RequestMapping("/list.do")
	public String list(Model model, @RequestParam(value = "pageNum", required = false)
	// int pageNum 파라메터 pageNum이 없이 경우 int에 null이 들어가지 못함
	Integer pageNum, // 정수이지만 null을 넣을 수 없음
			HttpServletRequest req) {
		TodoDTO todoDTO = new TodoDTO();
//		int pageNum = 3; // 현재 페이지 번호 

		if (pageNum == null) {
			pageNum = 1;
		}
		System.out.println("pageNum : " + pageNum);

		String cpp = req.getParameter("countPerpage");
		int countPerpage = 10;
		try {
			countPerpage = Integer.parseInt(cpp);
		} catch (Exception e) {
			e.printStackTrace();
		}

//		int countPerpage =10; // 한 페이지당 표시 수 
		int startNum = ((pageNum - 1) * countPerpage) + 1;
		int endNum = startNum + (countPerpage - 1);

		todoDTO.setStartNum(startNum);
		todoDTO.setEndNum(endNum);

		req.setAttribute("pageNum", pageNum);
		model.addAttribute("countPerpage", countPerpage);

		Map map = todoService.list(todoDTO);
//		model.addAttribute("map", map);

		List<TodoDTO> list = (List<TodoDTO>) map.get("list");
		model.addAttribute("list", list);

		int total = (int) map.get("totalCount");
		req.setAttribute("total", total);

		return "todo/list";
	}

	@RequestMapping("/update.do")
	public String updatePage(@RequestParam("todo_id") int todo_id, Model model) {

		TodoDTO todoDTO = todoService.detailTodo(todo_id);
		model.addAttribute("total", 106);

		return "todo/update";
	}

	@RequestMapping("/update")
	public String update(@ModelAttribute TodoDTO todoDTO) {
		System.out.println("todoDTO.getUser_id :" + todoDTO.getUser_id());
		int updateResult = todoService.updateTodo(todoDTO);
		System.out.println("updateResult : " + updateResult);
		return "redirect:/list.do";
	}

	@RequestMapping("/delete")
	public String delete(@ModelAttribute TodoDTO todoDTO) {

		int deleteResult = todoService.deleteTodo(todoDTO);
		System.out.println("updateResult : " + deleteResult);
		return "redirect:/list.do";
	}

	@RequestMapping("/api/update")
	@ResponseBody
	public int update2(@RequestBody TodoDTO todoDTO) {

		System.out.println("todoDTO.getTodo_id : " + todoDTO.getTodo_id());
		System.out.println("todoDTO.getTodo : " + todoDTO.getTodo());

		int updateResult = todoService.updateTodo(todoDTO);
		System.out.println("updateResult : " + updateResult);

		return updateResult;
	}

}

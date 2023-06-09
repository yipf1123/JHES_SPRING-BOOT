package com.study.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.springboot.dao.ISimpleBbsDao;
import com.study.springboot.dto.SimpleBbsDto;

@Controller
public class MyController {
	
	@Autowired
	ISimpleBbsDao dao;

	@RequestMapping("/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	
	@RequestMapping("/write")
	public String write(
			@ModelAttribute SimpleBbsDto dto,
			Model model
	) {
		// 요청한 내용을 받아서 변수에 저장
		String writer = dto.getWriter();
		String title = dto.getTitle();
		String content = dto.getContent();
		
		// 콘솔에 출력
		System.out.println("writer : "+ writer);
		System.out.println("title : "+ title);
		System.out.println("content : "+ content);
		
		// 요청한 내용을 받아서 DB에 저장
		int result = dao.writeDao(writer, title, content);
		System.out.println("writeDao result : "+ result);
		
//		return userlistPage(model);
		return "redirect:/list";
	}
	
	@RequestMapping("/list")
	public String userlistPage(Model model) {
		
		List<SimpleBbsDto> list = dao.listDao();
		
		model.addAttribute("list", list);
		
		return "list";
	}
	
	@RequestMapping("/view")
	public String view(Model model,
			@RequestParam("id") String id
			) {
		// TODO
//		- id값을 받아서
		System.out.println("str_id : "+ id);
		
		// 문자를 숫자로
		int n_id = -1;
		try {
			n_id = Integer.parseInt(id);
		} catch (Exception e) {
			n_id = -1;
		}
		
//		- 조회한 내용을
		SimpleBbsDto dto = dao.viewDao(id);

//		- jsp로 보냄
		model.addAttribute("dto", dto);
		return "view";
	}
	
	@RequestMapping("/modifyForm")
	public String modifyForm(
			@RequestParam("id") String id,
			Model model
	) {
		System.out.println("/modifyForm : id : "+ id);
		
		SimpleBbsDto dto = dao.viewDao(id);
		model.addAttribute("dto", dto);
		
		return "modifyForm";
	}
	@RequestMapping("/modify")
	public String modify(
		@ModelAttribute SimpleBbsDto dto,
		Model model
	) {
		int result = dao.updateDao(dto);
		System.out.println("업데이트 결과 : "+ result);
		
		return "redirect:/list";
	}
	
	@RequestMapping("/delete")
	public String delete(
		@RequestParam("id") String id
	) {
		
		int result = dao.deleteDao(id);
		System.out.println("삭제 개수 : "+ result);
		
		return "redirect:/list";
	}
}

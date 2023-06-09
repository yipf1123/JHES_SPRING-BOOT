package com.study.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.dao.ISimpleBbsDao;
import com.study.springboot.dto.SimpleBbsDto;

@Controller
public class MyController {
	
	@Autowired
	ISimpleBbsDao dao;

	@RequestMapping("/writeForm")
	public String writeForm() {
		System.out.println("writeForm 접속완료");
		return "writeForm";
	}

	@RequestMapping ("/write")
	public String write(
			@ModelAttribute SimpleBbsDto dto,
			Model model) {
		
		//요청한 내용을 받아서
		String writer = dto.getWriter();
		String title = dto.getTitle();
		String content = dto.getContent();
		
		//콘솔에 출력
		System.out.println("writer :" + writer);
		System.out.println("title :" + title);
		System.out.println("content :" + content);
		
		//요청한 내용을 받아서 DB에 저장
		int result = dao.writeDao(writer, title, content);
		System.out.println("writeDao result : " +result);
		
		return userlistPage(model);
		
	}
	
	@RequestMapping("/list")
	public String userlistPage(Model model) {
		List<SimpleBbsDto> list = dao.listDao();
		
		model.addAttribute("list", list);
		
		return "list";
	}
}

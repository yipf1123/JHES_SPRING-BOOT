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

	@RequestMapping("/view")
	public String view(Model model,
			@RequestParam("id") String id
			) {
		// TODO
//		- id값을 받아서
		System.out.println("str_id :" + id );
		
		//문자를 숫자로
		int n_id = -1;
		try {			
			n_id = Integer.parseInt(id);		
		}catch (Exception e) { // 숫자형식이 아닌것이 들어왔을 때
			n_id = -1;
		}
		
		
// 		- 조회한 내용을		
		SimpleBbsDto dto = dao.viewDao(id);
		
//		- jsp로 보낸다
		model.addAttribute("dto",dto);

		return "view";
	}
	
	@RequestMapping("/modify")
	public String mdify(Model model,
			@RequestParam("id") String id) {
		System.out.println("수정페이지 접속완료");
		System.out.println("/modify Id :"  + id);
		int n_id = -1;
		try {			
			n_id = Integer.parseInt(id);		
		}catch (Exception e) { // 숫자형식이 아닌것이 들어왔을 때
			n_id = -1;
		}
		
		
// 		- 조회한 내용을		
		SimpleBbsDto dto = dao.viewDao(id);
		
//		- jsp로 보낸다
		model.addAttribute("dto",dto);

		return "modify";
	}
	
	
	/*
	 * @RequestMapping("/rewrite") public String rewrite(Model model,
	 * 
	 * @ModelAttribute SimpleBbsDto dto) {
	 * 
	 * //요청한 내용을 받아서 String writer = dto.getWriter(); String title = dto.getTitle();
	 * String content = dto.getContent(); int id = dto.getId(); String id2 = ""+id;
	 * int result = dao.updateDao(writer, title, content, id);
	 * System.out.println("writeDao result : " +result);
	 * 
	 * 
	 * return view(model,id2); }
	 */
	
	
	@RequestMapping("/rewrite")
	public String rewrite(Model model,
			@ModelAttribute SimpleBbsDto dto) {
		
		//요청한 내용을 받아서
		String writer = dto.getWriter();
		String title = dto.getTitle();
		String content = dto.getContent();
		int id =  dto.getId();
		
		int result = dao.updateDao(writer, title, content, id);
		System.out.println("writeDao result : " +result);
		
		
		return "redirect:/view?id=" + id;
	}
	
}





















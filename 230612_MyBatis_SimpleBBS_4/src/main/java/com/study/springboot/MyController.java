package com.study.springboot;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.springboot.dao.ISimpleBbsDao;
import com.study.springboot.dto.SimpleBbsDto;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ISimpleBbsDao dao;

	@RequestMapping("/writeForm")
	public String writeForm() {
		return "writeForm";
	}

	@RequestMapping("/write")
	public String write(@ModelAttribute SimpleBbsDto dto, Model model) {
		// 요청한 내용을 받아서 변수에 저장
		String writer = dto.getWriter();
		String title = dto.getTitle();
		String content = dto.getContent();

		// 콘솔에 출력
		System.out.println("writer : " + writer);
		System.out.println("title : " + title);
		System.out.println("content : " + content);

		// 요청한 내용을 받아서 DB에 저장
		int result = dao.writeDao(writer, title, content);
		System.out.println("writeDao result : " + result);

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
	public String view(Model model, @RequestParam("id") String id) {
		// TODO
//		- id값을 받아서
		System.out.println("str_id : " + id);

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
	public String modifyForm(@RequestParam("id") String id, Model model) {
		System.out.println("/modifyForm : id : " + id);

		SimpleBbsDto dto = dao.viewDao(id);
		model.addAttribute("dto", dto);

		return "modifyForm";
	}

	@RequestMapping("/modify")
	public String modify(@ModelAttribute SimpleBbsDto dto, Model model) {
		int result = dao.updateDao(dto);
		System.out.println("업데이트 결과 : " + result);

		return "redirect:/list";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("id") String id) {

		int result = dao.deleteDao(id);
		System.out.println("삭제 개수 : " + result);

		return "redirect:/list";
	}

	// 주소창에 "...:8080/testIf"
	@RequestMapping("/testIf")
	public String testIf(
			// 전달인자가 dto의 필드명(setter 양식)과 일치하면
			// 값을 넣어줌
			@ModelAttribute SimpleBbsDto dto,

			// jsp로 값을 보내기 위해 사용
			Model model,

			HttpServletRequest request) {
		String type = request.getParameter("type");
		String keyword = request.getParameter("keyword");
		System.out.println("type: " + type);
		System.out.println("keyword: " + keyword);

		if ("t".equals(type)) {
			dto.setTitle(keyword);
		} else if ("w".equals(type)) {
			dto.setWriter(keyword);
		}

		// 조건에 맞는 목록 선택
		List list = dao.testIf(dto);

		// 조회한 목록을 list라는 key로 담아서 jsp로 전달
		model.addAttribute("list", list);

		// list.jsp 호출
		return "list";
	}

	@RequestMapping("/testForeach")
	public String testForeach(@ModelAttribute SimpleBbsDto dto, Model model, HttpServletRequest request) {
		// getParameterValues 방법
		String[] list_chk = request.getParameterValues("chk");
		if (list_chk != null) {
			for (int i = 0; i < list_chk.length; i++) {
				System.out.println("list_chk[" + i + "] :" + list_chk[i]);
			}
		} else {
			System.out.println("list_chk is null");

		}

		System.out.println("------------------");

		list_chk = dto.getChk();
		if (list_chk != null) {
			for (int i = 0; i < list_chk.length; i++) {
				System.out.println("list_chk[" + i + "] :" + list_chk[i]);

				logger.info("list_chk[" + i + "] :" + list_chk[i]);
			
			}
		} else {
			System.out.println("list_chk is null");

		}
		
		List list = dao.testForeach(dto);
		model.addAttribute("list", list);
		
		return "list";
	}
	
	@RequestMapping ("/chkDelete")
	public String chkDelete(@ModelAttribute SimpleBbsDto dto, Model model) {
		
		System.out.println("선택 삭제 진입 완료");
		System.out.println("chk : "+ dto.getChk());
		int result = dao.chkDelete(dto);
		System.out.println("삭제된 행의 수" + result);
		
		List list = dao.listDao();
		model.addAttribute("list", list);
		
		return "list";
	}
}

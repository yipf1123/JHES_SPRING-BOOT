package com.study.springboot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.dto.ShopDTO;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class ShopController {

	List<String> list = new ArrayList();// 위치가 포인트, id 값을 기록 남기기

	/*
	 * 브라우저에 전달한 값을 출력만
	 */
	@RequestMapping("/send1") // 모든 method를 받을 수 있음
	// @RequestMapping(value="/send1") // 위와 같음
	// @RequestMapping(value="/send1", method=RequestMethod.GET)
	// @GetMapping("/send1")// 위와 같음
	// @RequestMapping(value="/send1",
	// method={RequestMethod.GET,RequestMethod.POST})
	// get이 아닌 method로 들어오면 405 method not allowed
	// @PostMapping("/send1")
	public String print(HttpServletRequest request, // 인터넷과 자바를 연결하는

			// 들어올 때 필수; 없으면 400 bad request @:메소드
			@RequestParam("id") String id2,

			// 필수 아님; 없으면 null 이 들어감 (""과 비교하여 알아두셈)
			@RequestParam(value = "id", required = false) String id3,

			Model model) {

		// id에 해당하는 내용을 전달받아
		// 변수에 저장한다

		// HttpServletRequest request 와 짝꿍으로 쓰는 것
		// 전달받은 key값 중에서 여러개 중 첫번째것 하나만 가져옴
		String id = request.getParameter("id"); // querySelector 처럼
		// 전달받은 key값 일치한 모두를 가져옴
		String[] ids = request.getParameterValues("id"); // querySelectorAll 처럼

		System.out.println("id :" + id);
		System.out.println("id2 :" + id2);
		System.out.println("id3 :" + id3);
		for (String value : ids) {
			System.out.println("ids : " + value);

		}
		// 위는 콘솔창에 뜨는 파트
		////////////////////////////////////////////////////////////////////////////
		// jsp 내보내기

		model.addAttribute("req_id", id); // jsp로 보내는 친구

		list.add(id);// id 값을 기록 남기기
		model.addAttribute("list_id", list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + "번째 id : " + list.get(i));
		}

		request.setAttribute("req_id2", id);
		request.setAttribute("text", "abcd");
		request.setAttribute("m", "model");

		String req_id2 = (String) request.getAttribute("req_id2");
		System.out.println("req_id2 : " + req_id2);

		return "view";
	}

	@RequestMapping("/input")
	public String input() {

		return "input";
	}

	// get으로 전달하는 것
	//
	@ResponseBody
	@RequestMapping("/api/getBagList")
	public List getBagList(int count) {
		List list_item = new ArrayList();

		Map info = new HashMap();
		info.put("img_src", "//image.msscdn.net/images/goods_img/20230401/3199783/3199783_16844763299344_320.jpg");
		info.put("name", "보테가베네타");
		info.put("desc", "여성 카세트 크로스백 - 페러킷");
		info.put("price", "1,380,000");

		for (int i = 0; i < count; i++) {

			list_item.add(info);
		}

		return list_item;
	}

	@RequestMapping("/js_store")
	public String js_store() {

		return "js_store";
	}

	@RequestMapping("/send2")
	@ResponseBody
	public List send2(
			// Map을 이용하는 방법; 전부 받아줌
			@RequestParam Map paramMap,

			// 주소의 query string('?' 이후에 key=value 형태를 받음)
			// 따라서 post 일때는 못 받음
			@ModelAttribute ShopDTO shopDTO,

			// post 방식으로 json 받음
			@RequestBody ShopDTO shopDTO2) {
		System.out.println("/send2 진입");
		System.out.println("paramMap : " + paramMap);
		System.out.println(shopDTO.toString());
		System.out.println(shopDTO2);

		List list = getBagList(shopDTO2.getCount());

		return list;
	}

	@RequestMapping("/cookie")
	public String cookie(
			// 요청에 관한 모든 것
			HttpServletRequest request,

			// 응답에 관한 모든 것 - 브라우저까지 전송 됨
			// * model은 jsp까지만 전송 됨
			HttpServletResponse response) {

		// 쿠키 생성 및 설정
		Cookie cookie = new Cookie("popup3", "민수");
		cookie.setMaxAge(10); // 쿠키 유효기간 설정 단위: 초
		cookie.setPath("/"); // 쿠키의 유효 경로 설정
		response.addCookie(cookie); // 응답에 쿠키 추가

		// 쿠키 읽기
		Cookie[] cookies = request.getCookies(); // 요청에서 쿠키 배열 가져오기
		if (cookies != null) {
			for (Cookie c : cookies) {
				System.out.println("c : " + c);
				System.out.println("c.getName() : " + c.getName());
				System.out.println("c.getValue() : " + c.getValue());
			}
		}
		return "cookie";
	}

	// 세션은 서버 측에서 유지되는 데이터 저장소로, 사용자의 상태를 유지하기 위한 기술
	@RequestMapping("/session")
	public String session(HttpServletRequest request) {
		// 세션 : 30분의 유효기간
		// JSESSIONID라는 키를 가지는 세션쿠키를 이용

		// 세션을 가져오는 방법
		HttpSession session = request.getSession();
		boolean isNew = session.isNew(); // 최초 접속:true
		System.out.println("isNew : " + isNew);

		session.setAttribute("isLogin", "true");

		return "session";
	}

	@RequestMapping("/session2")
	public String session2(HttpServletRequest request) {

		HttpSession session = request.getSession();

		String isLogin = (String) session.getAttribute("isLogin");
		System.out.println("isLogin : " + isLogin);
		try {
			// isLogin.equals("true")
			if (isLogin != null && "true".equals(isLogin)) {
				System.out.println("로그인 되어있습니다.");
			} else {
				System.out.println("로그인 페이지로 이동합니다.");
			}

		} catch (Exception e) {
			System.out.println("로그인 페이지로 이동합니다.");
		}

		return "session";
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();

		session.invalidate(); 
		// 로그인이 풀려 버리는
		// 호출되는 즉시 세션이 소멸되는 건 아니다.

		return "session";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	
	@RequestMapping("/mypage")
	public String mypage(
			HttpServletRequest request,
			Model model
			
			) {
		
		String nextPage = "login";
		
		// 세션 가져오기
		HttpSession session = request.getSession();
		
		// 세션에 저장
		String id =(String) session.getAttribute("isLogin2");
		System.out.println("id : " + id);
		if( id != null) {
			model.addAttribute("id",id);
			nextPage = "mypage";
		} else {
			model.addAttribute("msg", "로그인 해주세요");
		}
		
		return nextPage;
	}
	
	@RequestMapping("/login_check")
	public String login_check(
			HttpServletRequest request,
			
			
			@RequestParam("pw") String pw,
			
			Model model
			) {
		String nextPage = null;
		String id = request.getParameter("id");
		
		String _id = "admin";
		String _pw = "1234";
		
		if(id != null && pw != null) {
			if(id.equals(_id) && pw.equals(_pw)) {
				//로그인 확인 완료
				
				// 세션 가져오기
				HttpSession session = request.getSession();
				
				// 세션에 저장
				session.setAttribute("isLogin2", id);
				model.addAttribute("id",id);
				nextPage = "/mypage";
				
			} else {
				//회원 정보 없음
				model.addAttribute("msg", "회원이 아닙니다");
				nextPage = "/login";
			}
		}else {
			model.addAttribute("msg","아이디와 패스워드는 필수입니다.");
			nextPage="/login";
		}
		
		return "redirect:" + nextPage;
		// redirect는 페이지를 신규로 받는거라 model이 유지가 안됨.
	}
	
}

package com.study.springboot.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
// Bean으로 등록 ; 스프링이 원할때 가져다 쓸 수 있게 한다
public class MyController {

	@Autowired
	// Bean으로 등록되어있는 클래스들 중에서
	// Member 타입 변수에 들어갈 수 있는 클래스를 찾아서 (scan)
	// new 해서(IoC) (이미 new가 되어있는게 있다면 그것을 재활용)
	// 변수에 넣어준다 (DI)
	Member member1;
	// Member member1 = new member();

	@Autowired
	Member member2;
	@Autowired
	@Qualifier("printerB") // Bean 이름으로 가져온다
	Printer printer;

	@RequestMapping("/")
	// 127.0.0.1:8800/
	// 브라우저에 입력하는 주소
	// 사용자가 요청한 주소(URL)와 처리할 메소드를 연결해준다
	// 클래스에 관계 없이 유일해야 한다
	// @ResponseBody : 여기에 붙여도 됨 / 스트링 데이터로 보여줄때
	public @ResponseBody String root() {

//		return "<h1>Hello World</h1>";

		member1.print(); // printerA를 이용해서 출력
						 // Member 클래스에
						 //	@Autowired
						 // @Qualifier("printerA") 이게 있어서

		member1.setPrinter(printer);
		member1.print(); // printerB를 이용해서 출력

		if (member1 == member2) {
			System.out.println("동일한 객체 입니다. 싱글톤입니다.");
		} else {
			System.out.println("서로 다른 객체입니다.");
		}
		
		member2.print();
		
		return "Annotation 사용하기";
	}
}

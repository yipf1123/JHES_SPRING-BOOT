package com.study.springboot.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 이 클래스는 스프링 설정으로 사용됨을 의미한다
// crtl + shift + o
public class Config {

	
	@Bean // 자동으로 new 할 수 있게 = 리턴값이 빈 객체로 사용됨을 의미
	public Member member1() {
		Member member1 = new Member();
		member1.setName("홍길동");
		member1.setNickname("도사");
		member1.setPrinter(new PrinterA());
		// Member member1 = new Member("홍길동", "도사", new PrinterA());
		return member1;
	}
	
	@Bean (name ="hello") //별도의 이름을 지정하지 않으면 메서드 이름이 빈의 이름으로 등록됨
	public Member member2() {
		return new Member("전우치","도사", new PrinterA());
	}
	
	@Bean
	public PrinterA printerA() {
		return new PrinterA();
	}
	
	@Bean
	public PrinterB printerB() {
		return new PrinterB();
	}
	
	
	
	
}

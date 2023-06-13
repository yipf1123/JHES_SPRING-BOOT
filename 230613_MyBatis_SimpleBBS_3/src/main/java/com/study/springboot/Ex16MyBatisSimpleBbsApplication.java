package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class Ex16MyBatisSimpleBbsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex16MyBatisSimpleBbsApplication.class, args);
	}

}

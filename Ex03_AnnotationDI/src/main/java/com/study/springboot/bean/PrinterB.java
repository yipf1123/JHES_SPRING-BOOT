package com.study.springboot.bean;

import org.springframework.stereotype.Component;

@Component
public class PrinterB implements Printer {

	@Override
	public void print(String message) {
		// TODO Auto-generated method stub
		
		System.out.println("PtinterB : " + message);
		
	}
	

}

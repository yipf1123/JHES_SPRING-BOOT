package com.study.springboot.dto;

import java.time.LocalDate;

public class MakeItDto {
	
	private String id;
	private int pw;
	private int do_id;
	private LocalDate day;
	private String category;
	private String toDo;
	private boolean check_status;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPw() {
		return pw;
	}
	public void setPw(int pw) {
		this.pw = pw;
	}
	public int getDo_id() {
		return do_id;
	}
	public void setDo_id(int do_id) {
		this.do_id = do_id;
	}
	public LocalDate getDay() {
		return day;
	}
	public void setDay(LocalDate day) {
		this.day = day;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getToDo() {
		return toDo;
	}
	public void setToDo(String toDo) {
		this.toDo = toDo;
	}
	public boolean isCheck_status() {
		return check_status;
	}
	public void setCheck_status(boolean check_status) {
		this.check_status = check_status;
	}
	

	
}

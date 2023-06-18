package com.study.springboot.dto;

import java.sql.Date;


public class MakeItDto {
	
	private String id;
	private int pw;
	private int do_id;
	private Date day;
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
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
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

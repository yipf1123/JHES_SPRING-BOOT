package com.study.springboot.dto;

import java.sql.Date;

public class UserDTO {

	/*
	user_id	number(10)	NOT NULL,
	id	varchar2(30)	NULL,
	pw	varchar2(100)	NULL,
	name	varchar2(100)	NULL,
	join_date	date	DEFAULT sysdate
	 */
	

	private int user_id;
	private String id;
	private String pw;
	private String name;
	private Date join_date;
	
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getJoin_date() {
		return join_date;
	}
	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}
	
	
}

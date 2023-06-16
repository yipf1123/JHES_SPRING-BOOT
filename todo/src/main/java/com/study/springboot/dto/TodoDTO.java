package com.study.springboot.dto;

import java.sql.Date;

public class TodoDTO {
	
	private int todo_id;
	private String todo;
	private Date due_date;	//마감 예정일
	private Date done_date;	//실제 마감일
	private int user_id;
	
	
	public int getTodo_id() {
		return todo_id;
	}
	public void setTodo_id(int todo_id) {
		this.todo_id = todo_id;
	}
	public String getTodo() {
		return todo;
	}
	public void setTodo(String todo) {
		this.todo = todo;
	}
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	public Date getDone_date() {
		return done_date;
	}
	public void setDone_date(Date done_date) {
		this.done_date = done_date;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
	@Override
	public String toString() {
		return "TodoDTO [todo_id=" + todo_id + ", todo=" + todo + ", due_date=" + due_date + ", done_date=" + done_date
				+ ", user_id=" + user_id + "]";
	}
	
	
	
	
}

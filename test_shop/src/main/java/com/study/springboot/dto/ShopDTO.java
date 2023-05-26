package com.study.springboot.dto;

public class ShopDTO {

	private int count;
	private String type;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;

	}
	
	@Override
	public String toString() {
		return "ShopDTO [count=" + count + ", type=" + type + "]";
	}	
}

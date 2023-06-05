package com.study.springboot.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl2 implements BoardDAO{
	
	@Override
	public List selectList() {
		
		Map map = new HashMap();
		map.put("key", "value");
		map.put("key2", 123);
		
		List list = new ArrayList();
		test(list);
		map.put("list", list);
		
		List list2 = new LinkedList();
		test(list2);
		
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		
		list.get(0);
		
		return list;
	}
	
	void test(List al) {
		
	}

}

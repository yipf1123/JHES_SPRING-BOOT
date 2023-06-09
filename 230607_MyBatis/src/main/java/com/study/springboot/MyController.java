package com.study.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.jdbc.IMyUserDao;


@Controller
public class MyController {

	@Autowired
	private IMyUserDao userDao;

	@RequestMapping ("/user")
	public String UserlistPage(Model model){
		
		List list = userDao.list();
		model.addAttribute("users", list);
		
		
		return "userlist";
	}
	
}

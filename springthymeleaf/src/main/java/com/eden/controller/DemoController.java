package com.eden.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eden.entity.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("hello")
public class DemoController {
	
	@GetMapping("hello")
	public String hello() {
		
		System.out.println("Hello Thymeleaf!");
		return "index";
	}
	
	@GetMapping("demo")
	public String demo(Model model) {
		log.info("demo OK!");
		String ssSting="Hello Thymeleaf";
		model.addAttribute("msg", ssSting);
		return "index";
	}
	
	@GetMapping("value")
	public String sentvalue(HttpServletRequest request,Model model,HttpSession session) {
		String name="田中";
		Integer age=25;
		String access="<a href='http://www.google.com'>谷歌</a>";
		request.setAttribute("name", name);
		model.addAttribute("age", age);
		model.addAttribute("access", access);
		
		User user = new User(20,"栗原",2300.00,new Date());
		request.setAttribute("user", user);
		
		List<User> users= Arrays.asList(new User(21,"松本",4500.0,new Date()),
				new User(22,"内野",5700.0,new Date()),
				new User(23,"横山",7800.0,new Date()));
		
		request.setAttribute("users", users);
		
		session.setAttribute("username1", "山本");
		session.setAttribute("username", users);
		return "sentValue";
	}
	
	

}

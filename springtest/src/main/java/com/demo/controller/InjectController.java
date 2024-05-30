package com.demo.controller;

import java.text.SimpleDateFormat;
//import java.sql.Date;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InjectController {

	@Value("${name}")
	public String name;
	
	@Value("${age}")
	public Integer age;
	
	@Value("${birthday}")
	public Date birthday;
	
	@Value("${gender}")
	public boolean gender;
	
	
	@RequestMapping("inject")
	public String inject() {
		System.out.println(name);
		System.out.println(age);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String strBirthday = sdf.format(birthday);
		System.out.println(strBirthday);
		
		System.out.println(gender);
		
		return "Inject"+strBirthday;
	}
}

package com.eden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eden.entity.Employees;
import com.eden.service.ServiceEmployees;

@RestController
public class EmployeesController {
	
	@Autowired
	private ServiceEmployees serviceEmployees;
	
	//ServiceEmployees serviceEmployees=new ServiceEmployeesImpl();
	
	
	@RequestMapping("findall")
	public List<Employees> findall(){
		
		return serviceEmployees.findall(); 
	}
	
	@RequestMapping("save")
	public void save(Employees emp) {
		serviceEmployees.save(emp);
	}

}

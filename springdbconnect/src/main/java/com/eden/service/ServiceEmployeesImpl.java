package com.eden.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eden.dao.EmployeesDao;
import com.eden.entity.Employees;

@Service
@Transactional
public class ServiceEmployeesImpl implements ServiceEmployees{
	
	@Autowired
	private EmployeesDao employeesDao;

	@Override
	public List<Employees> findall() {
		
		return employeesDao.findall();
	}

	@Override
	public void save(Employees emp) {
		employeesDao.save(emp);
		
	}

	

}

package com.eden.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eden.dao.EmployeeDao;
import com.eden.entity.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	
	@Override
	public void add(Employee employee) {
		
		employeeDao.add(employee);
		
	}

	@Override
	public List<Employee> list() {
		
		return employeeDao.list();
	}

	@Override
	public void delete(Integer id) {
		
		employeeDao.delete(id);
		
	}

	@Override
	public Employee idByEmployee(Integer id) {
		
		return employeeDao.idByEmployee(id);
	}

	@Override
	public void update(Employee employee) {
		employeeDao.update(employee);
		
	}

	@Override
	public List<Employee> searchEmp(String searchName, String dateBegin, String dateEnd) {
		
		return employeeDao.searchEmp(searchName,dateBegin,dateEnd);
	}

	

	
}

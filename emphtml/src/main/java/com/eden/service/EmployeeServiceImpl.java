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
	public List<Employee> lists() {
		
		return employeeDao.lists();
	}

	@Override
	public void save(Employee employee) {
		
		employeeDao.save(employee);
	}

	@Override
	public Employee findById(Integer id) {
		
		return employeeDao.findById(id);
	}

	@Override
	public void update(Employee employee) {
		
		employeeDao.update(employee);
	}

	@Override
	public void delete(Integer id) {
		employeeDao.delete(id);
		
	}

	@Override
	public List<Employee> searchEmp(String dateBegin, String dateEnd, String topSalary, String lowSalary,
			String searchName) {
		
		return employeeDao.searchEmp(dateBegin,dateEnd,topSalary,lowSalary,searchName);
	}

	

}

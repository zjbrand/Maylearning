package com.eden.service;

import java.util.List;

import com.eden.entity.Employee;

public interface EmployeeService {

	void add(Employee employee);

	List<Employee> list();

	void delete(Integer id);

	Employee idByEmployee(Integer id);

	void update(Employee employee);

	List<Employee> searchEmp(String searchName, String dateBegin, String dateEnd);

	

	
	
	

}

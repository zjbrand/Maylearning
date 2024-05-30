package com.eden.service;

import java.util.List;

import com.eden.entity.Employee;

public interface EmployeeService {

	List<Employee> lists();

	void save(Employee employee);

	Employee findById(Integer id);

	void update(Employee employee);

	void delete(Integer id);

	List<Employee> searchEmp(String dateBegin, String dateEnd, String topSalary, String lowSalary, String searchName);

	

}

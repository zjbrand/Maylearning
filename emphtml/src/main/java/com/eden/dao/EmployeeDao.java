package com.eden.dao;

import java.util.List;

import com.eden.entity.Employee;

public interface EmployeeDao {

	List<Employee> lists();

	void save(Employee employee);

	Employee findById(Integer id);

	void update(Employee employee);

	void delete(Integer id);

	List<Employee> searchEmp(String dateBegin, String dateEnd, String topSalary, String lowSalary, String searchName);

	

}

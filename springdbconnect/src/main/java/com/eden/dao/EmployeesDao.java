package com.eden.dao;

import java.util.List;

import com.eden.entity.Employees;

public interface EmployeesDao {

	List<Employees> findall();

	void save(Employees emp);
}

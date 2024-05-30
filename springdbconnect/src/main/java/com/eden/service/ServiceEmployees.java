package com.eden.service;

import java.util.List;

import com.eden.entity.Employees;

public interface ServiceEmployees {

	List<Employees> findall();

	void save(Employees emp);

	
}

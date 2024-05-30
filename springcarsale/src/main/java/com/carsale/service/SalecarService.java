package com.carsale.service;

import java.util.List;

import com.carsale.entity.Salecar;

public interface SalecarService {

	List<Salecar> lists();

	void save(Salecar Salecar);

	Salecar findById(Integer carid);

	void update(Salecar Salecar);

	void delete(Integer carid);

	List<Salecar> searchCar(String dateBegin, String dateEnd, String topSalary, String lowSalary, String searchName);

	

}

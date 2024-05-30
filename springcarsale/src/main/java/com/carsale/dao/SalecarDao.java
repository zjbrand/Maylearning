package com.carsale.dao;

import java.util.List;

import com.carsale.entity.Salecar;

public interface SalecarDao {

	List<Salecar> lists();

	void save(Salecar salecar);

	Salecar findById(Integer carid);

	void update(Salecar salecar);

	void delete(Integer carid);

	List<Salecar> searchCar(String dateBegin, String dateEnd, String topSalary, String lowSalary, String searchName);

	

}

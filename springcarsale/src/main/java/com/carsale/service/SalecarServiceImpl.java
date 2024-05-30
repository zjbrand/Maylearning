package com.carsale.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carsale.dao.SalecarDao;
import com.carsale.entity.Salecar;

@Service
@Transactional
public class SalecarServiceImpl implements SalecarService{
	
	@Autowired
	private SalecarDao salecarDao;

	@Override
	public List<Salecar> lists() {
		
		return salecarDao.lists();
	}

	@Override
	public void save(Salecar salecar) {
		
		salecar.setModifyTime(new Date());
		
		salecarDao.save(salecar);
	}

	@Override
	public Salecar findById(Integer carid) {
		
		return salecarDao.findById(carid);
	}

	@Override
	public void update(Salecar salecar) {
		
		salecar.setModifyTime(new Date());
		
		salecarDao.update(salecar);
	}

	@Override
	public void delete(Integer carid) {
		salecarDao.delete(carid);
		
	}

	@Override
	public List<Salecar> searchCar(String dateBegin, String dateEnd, String topSalary, String lowSalary,
			String searchName) {
		
		return salecarDao.searchCar(dateBegin,dateEnd,topSalary,lowSalary,searchName);
	}

	

}

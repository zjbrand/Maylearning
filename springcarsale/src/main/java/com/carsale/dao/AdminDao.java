package com.carsale.dao;

import com.carsale.entity.Admin;

public interface AdminDao {

	Admin findByUserName(String adminname);

	void save(Admin admin);

}

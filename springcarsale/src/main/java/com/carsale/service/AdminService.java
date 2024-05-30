package com.carsale.service;

import com.carsale.entity.Admin;

public interface AdminService {

	void register(Admin admin);

	Admin login(String adminname, String password);

	

}

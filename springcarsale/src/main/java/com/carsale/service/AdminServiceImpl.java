package com.carsale.service;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;

import com.carsale.dao.AdminDao;
import com.carsale.entity.Admin;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDao adminDao;

	@Override
	public void register(Admin admin) {
		Admin userDB= adminDao.findByUserName(admin.getAdminname());
		
		if(!ObjectUtils.isEmpty(userDB)) throw new RuntimeException("このユーザー名は既に存在している！");
				
		String newpwd = DigestUtils.md5DigestAsHex(admin.getPassword().getBytes(StandardCharsets.UTF_8));
		
		admin.setPassword(newpwd);
		
		adminDao.save(admin);
	}

	@Override
	public Admin login(String adminname, String password) {
		Admin adminDB= adminDao.findByUserName(adminname);
		
		if(ObjectUtils.isEmpty(adminDB)) throw new RuntimeException("このユーザー名が存在していません！");
		
		String pwdSecrete = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
		
		if(!adminDB.getPassword().equals(pwdSecrete)) throw new RuntimeException("パスワードが間違っている！");
		
		return adminDB;
	}

}

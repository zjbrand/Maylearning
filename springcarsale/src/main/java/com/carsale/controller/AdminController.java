package com.carsale.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.carsale.entity.Admin;
import com.carsale.service.AdminService;
import com.carsale.utils.JwtUtils;
import com.carsale.utils.VerifyCodeUtils;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	
	@RequestMapping("login")
	public String login(String adminname,String password,HttpSession session) throws UnsupportedEncodingException {
		log.info("ユーザー名：{},パスワード：{}",adminname,password);
		
		try {
			Admin admin= adminService.login(adminname,password);
			
			session.setAttribute("admin", admin);
			
			if(admin!=null) {
				Map<String,Object> claims=new HashMap<>();
				claims.put("id",admin.getId());
				claims.put("adminname", admin.getAdminname());
				
				String jwt = JwtUtils.generateJwt(claims);
				
				session.setAttribute("token", jwt);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return "redirect:/login?msg="+URLEncoder.encode(e.getMessage(),"UTF-8");
		}
		
		return "redirect:/salecar/lists";
	}
	
	@RequestMapping("register")
	public String register(Admin admin,String code,HttpSession session) throws UnsupportedEncodingException {
		//System.out.println("Hello register");
		log.info("ユーザー名：{},名前：{},パスワード：{},性別：{},検証コード：{}",
				admin.getAdminname(),admin.getRealname(),admin.getPassword(),admin.isGender(),code);
		
		try {
			String sessionCode = session.getAttribute("code").toString();
			
			if(!sessionCode.equalsIgnoreCase(code)) throw new RuntimeException("検証コードは間違っている");
			
			adminService.register(admin);
		} catch (Exception e) {
			
			e.printStackTrace();
			return "redirect:/register?msg="+URLEncoder.encode(e.getMessage(),"UTF-8");
			
		}
		
		return "redirect:/login";
	}
	
	@GetMapping("generateImageCode")
	public void generateImageCode(HttpSession session,HttpServletResponse response) throws IOException {
		String code = VerifyCodeUtils.generateVerifyCode(4);
		
		session.setAttribute("code", code);
		
		response.setContentType("image/png");
		
		ServletOutputStream os = response.getOutputStream();
		
		VerifyCodeUtils.outputImage(180, 50, os, code);
	}

}

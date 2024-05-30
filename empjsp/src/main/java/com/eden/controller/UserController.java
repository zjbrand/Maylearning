package com.eden.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eden.entity.User;
import com.eden.service.UserService;
import com.eden.util.JwtUtils;
import com.eden.util.VerifyCodeUtils;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {
	
	private static final Logger log=LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		return "redirect:/login.jsp";
	}
	
	
	@PostMapping("login")
	public String login(String username,String password,HttpSession session) throws UnsupportedEncodingException {
		
		log.debug("うけたユーザー名：{},パスワード：{}",username,password);
		
		try {
			User user=userService.login(username,password);
			
			session.setAttribute("user", user);
			
			if(user!=null) {
				Map<String,Object> claims=new HashMap<>();
				claims.put("id",user.getId());
				claims.put("username", user.getUsername());
				
				String jwt = JwtUtils.generateJwt(claims);
				
				session.setAttribute("token", jwt);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return "redirect:/login.jsp?msg="+URLEncoder.encode(e.getMessage(),"UTF-8") ;
		}
		
		return "redirect:/employee/list";
		
	}
	
	@PostMapping("register")
	public String register(User user,String code,HttpSession session) throws UnsupportedEncodingException  {
		/*System.out.println(user.getUsername());
		System.out.println(user.getRealname());
		System.out.println(user.getPassword());
		System.out.println(user.isGender());
		System.out.println(code);*/
		
		log.debug("うけた検証コード：{}",code);
		log.debug("ユーザー名：{},名前：{}，パスワード:{},性別：{}",
				user.getUsername(),user.getRealname(),user.getPassword(),user.isGender());
		
		try {
			String sessionCode = session.getAttribute("code").toString();
			
			if(!sessionCode.equalsIgnoreCase(code)) throw new RuntimeException("入力した検証コードは間違いです");
			
			userService.register(user);
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return "redirect:/regist.jsp?msg="+URLEncoder.encode(e.getMessage(), "UTF-8");
		}
		
		return "redirect:/login.jsp";
	}
	
	
	@GetMapping("generateImageCode")
	public void generateImageCode(HttpSession session,HttpServletResponse response) throws IOException {
		
		//ランダムな文字列を生成する
		String code=VerifyCodeUtils.generateVerifyCode(4);
		
		//サーバーのセッションに配置する
		session.setAttribute("code", code);
		
		//レスポンスを介して画像作成
		response.setContentType("image/png");
		
		ServletOutputStream os = response.getOutputStream();
		
		VerifyCodeUtils.outputImage(220, 80, os, code);
	}

}

package com.eden.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.eden.interceptor.LoginCheckInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	@Autowired
	private LoginCheckInterceptor loginCheckInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		//registry.addInterceptor(loginCheckInterceptor).addPathPatterns("/**").excludePathPatterns("/**/.");
		registry.addInterceptor(loginCheckInterceptor).addPathPatterns("/**").excludePathPatterns("/css","/img","script");
	}

	
}

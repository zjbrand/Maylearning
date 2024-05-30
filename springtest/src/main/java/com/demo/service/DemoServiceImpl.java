package com.demo.service;

import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService{

	@Override
	public void demo() {
		
		System.out.println("DemoService OK");
		
	}

}

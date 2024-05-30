package com.eden;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.eden.dao")
public class EmphtmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmphtmlApplication.class, args);
	}

}

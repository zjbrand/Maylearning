package com.carsale;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.carsale.dao")
public class SpringcarsaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcarsaleApplication.class, args);
	}

}

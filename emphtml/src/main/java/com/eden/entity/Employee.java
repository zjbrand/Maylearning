package com.eden.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	private Integer id;
	private String name;
	private Double salary;
	private Date birthday;
	private String photo;

}

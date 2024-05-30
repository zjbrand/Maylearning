package com.carsale.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
	
	private Integer id;
	private String adminname;
	private String realname;
	private String password;
	private boolean gender;

}

package com.eden.entity;

import java.util.Date;

public class Employee {
	
	private Integer id;
	private String name;
	private Date birthday;
	private Double salary;
	private boolean gender;
	
		
	public Employee() {
		super();
	}
	
	public Employee(Integer id, String name, Date birthday, Double salary, boolean gender) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.salary = salary;
		this.gender = gender;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	
	
	

}

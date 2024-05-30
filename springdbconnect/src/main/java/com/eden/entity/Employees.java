package com.eden.entity;

public class Employees {
	
	private Integer employee_id;
	private String employee_name;
	private String gender;
	private Integer age;
	private String department;
	private Integer salary;
	private String address;
	private String id_card_number;
	
	
	
	public Employees() {
		super();
	}

	public Employees(Integer employee_id, String employee_name, String gender, Integer age, String department,
			Integer salary, String address, String id_card_number) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.gender = gender;
		this.age = age;
		this.department = department;
		this.salary = salary;
		this.address = address;
		this.id_card_number = id_card_number;
	}
	
	public Integer getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getId_card_number() {
		return id_card_number;
	}
	public void setId_card_number(String id_card_number) {
		this.id_card_number = id_card_number;
	}
	
	

}

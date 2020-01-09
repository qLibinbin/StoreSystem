package com.binbin.storesystem.model;

import java.util.Date;

public class User {
	/*create table user(
			user_id int AUTO_INCREMENT primary key,
			username varchar(20),
			account varchar(20) unique,
			sex varchar(2),
			age int,
			password varchar(20),
			address varchar(20),
			phone_number varchar(20),
			register_time date
		);*/
	private Integer userId;
	private String username;
	private String account;
	private String password;
	private String sex;
	private Integer age;
	private String address;
	private String phoneNumber;
	private Date registerTime;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", account=" + account + ", password=" + password
				+ ", sex=" + sex + ", age=" + age + ", address=" + address + ", phoneNumber=" + phoneNumber
				+ ", registerTime=" + registerTime + "]";
	}
	
	
}

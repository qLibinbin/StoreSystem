package com.binbin.storesystem.model;

import java.util.Date;

public class Business {
	/*create table business(
			business_id int AUTO_INCREMENT primary key,
			business_name varchar(20),
			account varchar(20) unique,
			password varchar(20),
			address varchar(20),
			phone_number varchar(20),
			register_time date
		);*/
	private Integer businessId;
	private String businessName;
	private String account;
	private String password;
	private String address;
	private String phoneNumber;
	private Date registerTime;

	public Integer getBusinessId() {
		return businessId;
	}
	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
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
		return "Business [businessId=" + businessId + ", businessName=" + businessName + ", account=" + account
				+ ", password=" + password + ", address=" + address + ", phoneNumber=" + phoneNumber + ", registerTime="
				+ registerTime + "]";
	}
	
	
	
}

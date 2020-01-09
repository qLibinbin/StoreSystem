package com.binbin.storesystem.model;

public class Order {
	/*create table orders(
			order_id int AUTO_INCREMENT primary key,
			user_id int,
			is_pay varchar(2),
			delivery_method varchar(20),
			foreign key(user_id) references user(user_id)
		);*/
	private Integer orderId;
	private Integer userId;
	private String isPay;
	private String deliveryMethod;
	
	
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getIsPay() {
		return isPay;
	}
	public void setIsPay(String isPay) {
		this.isPay = isPay;
	}
	public String getDeliveryMethod() {
		return deliveryMethod;
	}
	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}
	
	
}

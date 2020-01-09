package com.binbin.storesystem.model;

public class OrderItem {
	private Integer order_id;
	private Integer user_id;
	private String is_pay;
	private String delivery_method;
	
	private Integer numbers;
	private Integer product_id;
	private Integer business_id;
	private String product_name;
	private Integer price;
	
	private String product_info;

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getIs_pay() {
		return is_pay;
	}

	public void setIs_pay(String is_pay) {
		this.is_pay = is_pay;
	}

	public String getDelivery_method() {
		return delivery_method;
	}

	public void setDelivery_method(String delivery_method) {
		this.delivery_method = delivery_method;
	}

	public Integer getNumbers() {
		return numbers;
	}

	public void setNumbers(Integer numbers) {
		this.numbers = numbers;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public Integer getBusiness_id() {
		return business_id;
	}

	public void setBusiness_id(Integer business_id) {
		this.business_id = business_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getProduct_info() {
		return product_info;
	}

	public void setProduct_info(String product_info) {
		this.product_info = product_info;
	}

	@Override
	public String toString() {
		return "OrderItem [order_id=" + order_id + ", user_id=" + user_id + ", is_pay=" + is_pay + ", delivery_method="
				+ delivery_method + ", numbers=" + numbers + ", product_id=" + product_id + ", business_id="
				+ business_id + ", product_name=" + product_name + ", price=" + price + ", product_info=" + product_info
				+ "]";
	}
	
	
	
	
}

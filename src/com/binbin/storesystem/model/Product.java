package com.binbin.storesystem.model;

public class Product {
	/*create table product(
			product_id int AUTO_INCREMENT primary key,
			business_id int,
			product_name varchar(20),
			price int,
			product_info varchar(20),
			numbers int,
			foreign key(business_id) references business(business_id)
		);*/
	
	private Integer productId;
	private Integer businessId;
	private String productName;
	private Integer price;
	private String productInfo;
	private Integer numbers;
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getBusinessId() {
		return businessId;
	}
	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}
	public Integer getNumbers() {
		return numbers;
	}
	public void setNumbers(Integer numbers) {
		this.numbers = numbers;
	}
	
	
}

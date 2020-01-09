package com.binbin.storesystem.mapper;

import java.util.List;

import com.binbin.storesystem.model.Product;

public interface ProductMapper {
	public int saveProduct(Product product);
	public List<Product> selectProductByName(String name);
	public List<Product> selectProductBybusinessId(int businessId);
	public Product selectProductById(int productId);
	public int updateProduct(Product product);
}

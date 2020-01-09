package com.binbin.storesystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binbin.storesystem.mapper.ProductMapper;
import com.binbin.storesystem.model.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductMapper productMapper;
	public boolean saveProduct(Product product) {
		int saveProduct = productMapper.saveProduct(product);
		if (saveProduct>0) {
			return true;
		}
		return false;
	}
	public List<Product> selectProductByBusinessId(Integer businessId) {
		List<Product> productlist = productMapper.selectProductBybusinessId(businessId);
		return productlist;
	}
	public List<Product> selectProductByProductName(String productName) {
		List<Product> productlist = productMapper.selectProductByName(productName);
		return productlist;
	}
	public Product selectProductById(Integer productId) {
		Product product = productMapper.selectProductById(productId);
		return product;
	}
	public boolean updateProduct(Product product) {
		int updateProduct = productMapper.updateProduct(product);
		if (updateProduct>0) {
			return true;
		}
		return false;
	}
	
}

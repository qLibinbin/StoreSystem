package com.binbin.storesystem.service;

import java.util.List;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.binbin.storesystem.mapper.OrderMapper;
import com.binbin.storesystem.mapper.ProductMapper;
import com.binbin.storesystem.model.Order;
import com.binbin.storesystem.model.OrderItem;
import com.binbin.storesystem.model.Product;

@Service
public class OrderService {
	
	@Autowired 
	private ProductMapper productMapper;
	
	@Autowired 
	private OrderMapper orderMapper;
	
	@Transactional
	public boolean newOrder(Integer productId,Integer userId,Integer buyNumbers) {
		
		Product product = productMapper.selectProductById(productId);
		if (product!=null && product.getNumbers()>buyNumbers) {
			product.setNumbers(product.getNumbers()-buyNumbers);
			int updateProduct = productMapper.updateProduct(product);
			
			Order order=new Order();
			order.setUserId(userId);
			orderMapper.saveOrder(order);
			
			System.out.println(order.getOrderId());
			
			int addProductToOrder = orderMapper.addProductToOrder(order.getOrderId(),productId,buyNumbers);
			if (addProductToOrder>0) {
				return true;
			}
		}
		
		
		return false;
	}

	public List<OrderItem> getOrderItemByUserId(Integer userId) {
		List<OrderItem> list = orderMapper.selectOrderItemByUserId(userId);
		return list;
	}

	public List<OrderItem> getOrderItemByBusinessId(Integer businessId) {
		List<OrderItem> list = orderMapper.selectOrderItemByBusinessId(businessId);
		return list;
	}
	
}

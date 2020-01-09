package com.binbin.storesystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.binbin.storesystem.model.Order;
import com.binbin.storesystem.model.OrderItem;

public interface OrderMapper {
	public List<Order> selectOrderByUserId(Integer userId);
	public int saveOrder(Order order);
	public int addProductToOrder(@Param("orderId")Integer orderId, @Param("productId")Integer productId,@Param("buyNumbers") Integer buyNumbers);
	public List<OrderItem> selectOrderItemByUserId(Integer userId);
	public List<OrderItem> selectOrderItemByBusinessId(Integer businessId);
}

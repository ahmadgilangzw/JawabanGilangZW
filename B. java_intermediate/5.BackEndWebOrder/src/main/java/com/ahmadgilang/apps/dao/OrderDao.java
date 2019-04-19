package com.ahmadgilang.apps.dao;

import java.util.List;

import com.ahmadgilang.apps.entity.Order;

public interface OrderDao {

	public List<Order> findAll();
	
	public void insertOrder(Order order);

	public void updateOrder(Order order);

	public void deleteOrder(Order order);
	
	public void truncateOrder();

}

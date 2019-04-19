package com.ahmadgilang.apps.service;

import java.util.List;

import com.ahmadgilang.apps.entity.Order;

public interface OrderService {
	
	public List<Order> findAll();

	public void insertOrder(Order order);

	public void updateOrder(Order order);

	public void deleteOrder(Order order);
	
	public void truncateOrder();
	
	public void readAndInsertOrder(String fileName);
	
}

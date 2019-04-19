package com.ahmadgilang.apps.service;

import java.util.List;

import com.ahmadgilang.apps.entity.Order;

public interface OrderService {
	
	public List<Order> findAll();

	public void readAndInsertOrder(String fileName);
	
}

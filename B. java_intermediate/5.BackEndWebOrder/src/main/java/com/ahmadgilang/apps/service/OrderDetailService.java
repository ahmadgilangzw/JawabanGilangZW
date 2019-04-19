package com.ahmadgilang.apps.service;

import java.util.List;

import com.ahmadgilang.apps.entity.OrderDetail;

public interface OrderDetailService {
	
	public List<OrderDetail> findAll();

	public void insertOrderDetail(OrderDetail orderDetail);

	public void updateOrderDetail(OrderDetail orderDetail);

	public void deleteOrderDetail(OrderDetail orderDetail);
	
	public void truncateOrderDetail();
	
	public void readAndInsertOrderDetail(String fileName);
	
}

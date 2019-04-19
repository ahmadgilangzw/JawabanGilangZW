package com.ahmadgilang.apps.service;

import java.util.List;

import com.ahmadgilang.apps.entity.OrderDetail;

public interface OrderDetailService {
	
	public List<OrderDetail> findAll();

	public void readAndInsertOrderDetail(String fileName);
	
}

package com.ahmadgilang.apps.dao;

import java.util.List;

import com.ahmadgilang.apps.entity.OrderDetail;

public interface OrderDetailDao {

	public List<OrderDetail> findAll();

	public List<OrderDetail> findAllByParam(Long orderId);
	
	public void insertOrderDetail(OrderDetail orderDetail);

	public void updateOrderDetail(OrderDetail orderDetail);

	public void deleteOrderDetail(OrderDetail orderDetail);
	
	public void truncateOrderDetail();

}

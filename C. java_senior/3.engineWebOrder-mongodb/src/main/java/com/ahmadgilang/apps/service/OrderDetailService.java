package com.ahmadgilang.apps.service;

import com.ahmadgilang.apps.entity.OrderDetail;

import reactor.core.publisher.Flux;

public interface OrderDetailService {
	
	public Flux<OrderDetail> findAll();
	
	Flux<OrderDetail> findAllByOrderId(String orderId);

}
package com.ahmadgilang.apps.service;

import com.ahmadgilang.apps.entity.Order;

import reactor.core.publisher.Flux;

public interface OrderService {
	
	public Flux<Order> findAll();

}

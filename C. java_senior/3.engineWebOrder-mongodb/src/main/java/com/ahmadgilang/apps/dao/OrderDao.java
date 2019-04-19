package com.ahmadgilang.apps.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.ahmadgilang.apps.entity.Order;

public interface OrderDao extends ReactiveMongoRepository<Order, String> {
	
	
}

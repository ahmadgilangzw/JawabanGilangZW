package com.ahmadgilang.apps.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.ahmadgilang.apps.entity.OrderDetail;

import reactor.core.publisher.Flux;

public interface OrderDetailDao extends ReactiveMongoRepository<OrderDetail, Long> {

	Flux<OrderDetail> findAllByOrderId(String orderId);
	
}

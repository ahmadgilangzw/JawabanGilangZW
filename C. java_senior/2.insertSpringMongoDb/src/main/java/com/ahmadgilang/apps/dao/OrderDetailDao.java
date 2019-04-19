package com.ahmadgilang.apps.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ahmadgilang.apps.entity.OrderDetail;

public interface OrderDetailDao extends MongoRepository<OrderDetail, Long> {
	
}

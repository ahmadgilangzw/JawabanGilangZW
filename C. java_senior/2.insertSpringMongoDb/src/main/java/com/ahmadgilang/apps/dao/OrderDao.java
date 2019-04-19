package com.ahmadgilang.apps.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ahmadgilang.apps.entity.Order;

public interface OrderDao extends MongoRepository<Order, Long> {

}

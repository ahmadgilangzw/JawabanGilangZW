package com.ahmadgilang.apps.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ahmadgilang.apps.entity.ShippingMethod;

public interface ShippingMethodDao extends MongoRepository<ShippingMethod, Long> {
	
}

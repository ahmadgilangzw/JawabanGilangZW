package com.ahmadgilang.apps.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.ahmadgilang.apps.entity.ShippingMethod;

import reactor.core.publisher.Mono;

public interface ShippingMethodDao extends ReactiveMongoRepository<ShippingMethod, Long>{

	Mono<ShippingMethod> findBy_id(String shippingMethodId);
	
}

package com.ahmadgilang.apps.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.ahmadgilang.apps.entity.Product;

import reactor.core.publisher.Mono;

public interface ProductDao extends ReactiveMongoRepository<Product, Long>{

	Mono<Product> findBy_id(String productId);
	
}

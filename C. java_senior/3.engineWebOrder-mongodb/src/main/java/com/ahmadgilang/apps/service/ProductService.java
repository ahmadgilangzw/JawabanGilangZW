package com.ahmadgilang.apps.service;

import com.ahmadgilang.apps.entity.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
	
	public Flux<Product> findAll();
	
	public Mono<Product> getById(String id);

}

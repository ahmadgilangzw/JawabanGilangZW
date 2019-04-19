package com.ahmadgilang.apps.service;

import com.ahmadgilang.apps.entity.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {
	
	public Flux<Customer> findAll();
	
	public Mono<Customer> getById(String id);

}

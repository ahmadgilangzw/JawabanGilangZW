package com.ahmadgilang.apps.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.ahmadgilang.apps.entity.Customer;

import reactor.core.publisher.Mono;

public interface CustomerDao extends ReactiveMongoRepository<Customer, String>{

	Mono<Customer> findBy_id(String customerId);

}

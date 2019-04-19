package com.ahmadgilang.apps.service;

import com.ahmadgilang.apps.entity.ShippingMethod;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ShippingMethodService {
	
	public Flux<ShippingMethod> findAll();
	
	public Mono<ShippingMethod> getById(String id);

}

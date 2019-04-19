package com.ahmadgilang.apps.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ahmadgilang.apps.dao.ShippingMethodDao;
import com.ahmadgilang.apps.entity.ShippingMethod;
import com.ahmadgilang.apps.service.ShippingMethodService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ShippingMethodServiceImpl implements ShippingMethodService{
	
	@Resource 
	ShippingMethodDao shippingMethodDao;
	
	@Override
	public Flux<ShippingMethod> findAll() {
		return shippingMethodDao.findAll();
	}

	@Override
	public Mono<ShippingMethod> getById(String id) {
		return shippingMethodDao.findBy_id(id);
	}
	
}

package com.ahmadgilang.apps.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ahmadgilang.apps.dao.CustomerDao;
import com.ahmadgilang.apps.entity.Customer;
import com.ahmadgilang.apps.service.CustomerService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CustomerServiceImpl implements CustomerService{
	
	@Resource 
	CustomerDao customerDao;
	
	@Override
	public Flux<Customer> findAll() {
		return customerDao.findAll();
	}

	@Override
	public Mono<Customer> getById(String id) {
		return customerDao.findBy_id(id);
	}
	
}

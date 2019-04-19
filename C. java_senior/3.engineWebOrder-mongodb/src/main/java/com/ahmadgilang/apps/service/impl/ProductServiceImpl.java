package com.ahmadgilang.apps.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ahmadgilang.apps.dao.ProductDao;
import com.ahmadgilang.apps.entity.Product;
import com.ahmadgilang.apps.service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ProductServiceImpl implements ProductService{
	
	@Resource 
	ProductDao productDao;
	
	@Override
	public Flux<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	public Mono<Product> getById(String id) {
		return productDao.findBy_id(id);
	}
	
}

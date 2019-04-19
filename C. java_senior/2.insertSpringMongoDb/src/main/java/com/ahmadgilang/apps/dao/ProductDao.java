package com.ahmadgilang.apps.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ahmadgilang.apps.entity.Product;

public interface ProductDao extends MongoRepository<Product, Long>{
	
}

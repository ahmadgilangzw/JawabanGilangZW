package com.ahmadgilang.apps.service;

import java.util.List;

import com.ahmadgilang.apps.entity.Product;

public interface ProductService {
	
	public List<Product> findAll();

	public void readAndInsertProduct(String fileName);
	
}

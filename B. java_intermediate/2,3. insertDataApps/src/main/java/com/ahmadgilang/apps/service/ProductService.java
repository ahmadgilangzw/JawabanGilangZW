package com.ahmadgilang.apps.service;

import java.util.List;

import com.ahmadgilang.apps.entity.Product;

public interface ProductService {
	
	public List<Product> findAll();

	public void insertProduct(Product product);

	public void updateProduct(Product product);

	public void deleteProduct(Product product);
	
	public void truncateProduct();
	
	public void readAndInsertProduct(String fileName);
	
}

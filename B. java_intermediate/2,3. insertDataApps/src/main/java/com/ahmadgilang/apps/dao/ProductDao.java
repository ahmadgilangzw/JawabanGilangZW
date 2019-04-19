package com.ahmadgilang.apps.dao;

import java.util.List;

import com.ahmadgilang.apps.entity.Product;

public interface ProductDao {

	public List<Product> findAll();
	
	public void insertProduct(Product product);

	public void updateProduct(Product product);

	public void deleteProduct(Product product);
	
	public void truncateProduct();

}

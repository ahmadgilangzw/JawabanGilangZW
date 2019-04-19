package com.ahmadgilang.apps.service;

import java.util.List;

import com.ahmadgilang.apps.entity.Customer;

public interface CustomerService {
	
	public List<Customer> findAll();

	public void readAndInsertCustomer(String fileName);
	
}

package com.ahmadgilang.apps.dao;

import java.util.List;

import com.ahmadgilang.apps.entity.Customer;

public interface CustomerDao {

	public List<Customer> findAll();
	
	public void insertCustomer(Customer emp);

	public void updateCustomer(Customer emp);

	public void deleteCustomer(Customer emp);
	
	public void truncateCustomer();

}

package com.ahmadgilang.apps.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmadgilang.apps.service.CustomerService;
import com.ahmadgilang.apps.service.EmployeeService;
import com.ahmadgilang.apps.service.OrderDetailService;
import com.ahmadgilang.apps.service.OrderService;
import com.ahmadgilang.apps.service.ProductService;
import com.ahmadgilang.apps.service.ShippingMethodService;

@Service
public class ReadInsertData{
	
	@Autowired 
	private CustomerService customerService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ShippingMethodService shippingMethodService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderDetailService orderDetailService;
	
	public void executeData(){
		
		customerService.readAndInsertCustomer("Customers.csv");
		employeeService.readAndInsertEmployee("Employees.csv");
		shippingMethodService.readAndInsertShippingMethod("ShippingMethods.csv");
		productService.readAndInsertProduct("Products.csv");
		orderService.readAndInsertOrder("Orders.csv");
		orderDetailService.readAndInsertOrderDetail("OrderDetails.csv");
	
	}
	
}

package com.ahmadgilang.apps.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahmadgilang.apps.entity.Customer;
import com.ahmadgilang.apps.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Resource 
	CustomerService customerService;
	
	@GetMapping(value = "/getAllCustomer")
	public List<Customer> getAllCustomer() {
		return customerService.findAll();
	
	}
	
	@PostMapping(value = "/saveCustomer")
	public void saveCustomer(@RequestBody Customer cust) {
		 customerService.insertCustomer(cust);
	
	}
	@PutMapping(value = "/updateCustomer")
	public void updateCustomer(@RequestBody Customer cust) {
		 customerService.updateCustomer(cust);
	
	}
	
	@DeleteMapping(value = "/deleteCustomer")
	public void deleteCustomer(@RequestBody Customer cust) {
		 customerService.deleteCustomer(cust);
	
	}
	
	
}

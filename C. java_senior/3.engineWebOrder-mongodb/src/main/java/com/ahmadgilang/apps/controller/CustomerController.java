package com.ahmadgilang.apps.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ahmadgilang.apps.entity.Customer;
import com.ahmadgilang.apps.service.CustomerService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Resource 
	CustomerService customerService;
	
	@GetMapping(value = "/getAllCustomer")
	public Flux<Customer> getAllCustomer() {
		return customerService.findAll();
	
	}

	@GetMapping(value = "/getById")
	public Mono<Customer> getById(@RequestParam String id) {
		return customerService.getById(id);
		
	}
	
}

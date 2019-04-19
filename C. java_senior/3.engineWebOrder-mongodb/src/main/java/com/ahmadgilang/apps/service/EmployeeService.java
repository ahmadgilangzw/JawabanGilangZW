package com.ahmadgilang.apps.service;

import com.ahmadgilang.apps.entity.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {
	
	public Flux<Employee> findAll();
	
	public Mono<Employee> getById(String id);

}

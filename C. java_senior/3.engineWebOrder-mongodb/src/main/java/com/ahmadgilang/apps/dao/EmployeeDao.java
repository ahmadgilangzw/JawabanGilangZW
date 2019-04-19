package com.ahmadgilang.apps.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.ahmadgilang.apps.entity.Employee;

import reactor.core.publisher.Mono;

public interface EmployeeDao extends ReactiveMongoRepository<Employee, Long>{

	Mono<Employee> findBy_id(String employeeId);
	
}

package com.ahmadgilang.apps.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ahmadgilang.apps.dao.EmployeeDao;
import com.ahmadgilang.apps.entity.Employee;
import com.ahmadgilang.apps.service.EmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class EmployeeServiceImpl implements EmployeeService{
	
	@Resource 
	EmployeeDao employeeDao;
	
	@Override
	public Flux<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	public Mono<Employee> getById(String id) {
		return employeeDao.findBy_id(id);
	}
	
}

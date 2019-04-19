package com.ahmadgilang.apps.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ahmadgilang.apps.entity.Employee;
import com.ahmadgilang.apps.service.EmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Resource 
	EmployeeService employeeService;
	
	@GetMapping(value = "/getAllEmployee")
	public Flux<Employee> getAllEmployee() {
		return employeeService.findAll();
	}
	
	@GetMapping(value = "/getById")
	public Mono<Employee> getById(@RequestParam String id) {
		return employeeService.getById(id);
	}
	
}

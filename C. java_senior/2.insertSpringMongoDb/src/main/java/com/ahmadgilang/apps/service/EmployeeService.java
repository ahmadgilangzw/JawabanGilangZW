package com.ahmadgilang.apps.service;

import java.util.List;

import com.ahmadgilang.apps.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();

	public void readAndInsertEmployee(String fileName);
	
}

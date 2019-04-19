package com.ahmadgilang.apps.service;

import java.util.List;

import com.ahmadgilang.apps.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();

	public void insertEmployee(Employee emp);

	public void updateEmployee(Employee emp);

	public void deleteEmployee(Employee emp);
	
	public void truncateEmployee();
	
	public void readAndInsertEmployee(String fileName);
	
}

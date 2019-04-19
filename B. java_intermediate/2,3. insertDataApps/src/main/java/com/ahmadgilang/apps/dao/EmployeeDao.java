package com.ahmadgilang.apps.dao;

import java.util.List;

import com.ahmadgilang.apps.entity.Employee;

public interface EmployeeDao {

	public List<Employee> findAll();
	
	public void insertEmployee(Employee emp);

	public void updateEmployee(Employee emp);

	public void deleteEmployee(Employee emp);
	
	public void truncateEmployee();

}

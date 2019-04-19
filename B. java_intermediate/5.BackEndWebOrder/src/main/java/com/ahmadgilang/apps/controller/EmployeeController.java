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

import com.ahmadgilang.apps.entity.Employee;
import com.ahmadgilang.apps.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Resource 
	EmployeeService employeeService;
	
	@GetMapping(value = "/getAllEmployee")
	public List<Employee> getAllEmployee() {
		return employeeService.findAll();
	}
	
	@PostMapping(value = "/saveEmployee")
	public void saveEmployee(@RequestBody Employee employee) {
		employeeService.insertEmployee(employee);
	}
	@PutMapping(value = "/updateEmployee")
	public void updateEmployee(@RequestBody Employee employee) {
		employeeService.updateEmployee(employee);
	}
	
	@DeleteMapping(value = "/deleteEmployee")
	public void deleteEmployee(@RequestBody Employee employee) {
		employeeService.deleteEmployee(employee);
	}
	
}

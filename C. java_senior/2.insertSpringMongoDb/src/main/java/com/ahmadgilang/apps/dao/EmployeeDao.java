package com.ahmadgilang.apps.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ahmadgilang.apps.entity.Employee;

public interface EmployeeDao extends MongoRepository<Employee, Long> {

}

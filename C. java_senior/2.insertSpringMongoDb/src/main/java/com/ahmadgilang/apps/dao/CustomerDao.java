package com.ahmadgilang.apps.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ahmadgilang.apps.entity.Customer;

public interface CustomerDao extends MongoRepository<Customer, Long> {

}

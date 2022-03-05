package com.account.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.account.model.Customer;

public interface CustomerRepo extends MongoRepository<Customer, Long> {

}

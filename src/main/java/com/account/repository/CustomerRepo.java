package com.account.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.account.model.Customer;

public interface CustomerRepo extends MongoRepository<Customer, Long> {
	@Query("{'name':?0}")
	Optional<Customer> findByName(String name);

}

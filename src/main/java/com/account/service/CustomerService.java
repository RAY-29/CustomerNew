package com.account.service;

import javax.validation.ConstraintViolationException;

import org.springframework.stereotype.Service;

import com.account.exception.CustomerException;
import com.account.model.Customer;
public interface CustomerService {
	public void createCustomer(Customer customer) throws ConstraintViolationException, CustomerException;
	public void deleteCustomer(Long id) throws CustomerException;

}

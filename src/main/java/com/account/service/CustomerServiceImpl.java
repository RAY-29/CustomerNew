package com.account.service;

import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.exception.CustomerException;
import com.account.model.Customer;
import com.account.repository.CustomerRepo;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepo customerRepo;
	
	public void createCustomer(Customer customer) throws ConstraintViolationException, CustomerException {
		Optional<Customer> customerOptional= this.customerRepo.findById(customer.getId());
		if(customerOptional.isPresent()) {
			throw new CustomerException(CustomerException.CustomerAlreadyExists());
		}
		else {
			this.customerRepo.save(customer);
		}
	}

	@Override
	public void deleteCustomer(Long id) throws CustomerException {
		// TODO Auto-generated method stub
		Optional<Customer> c=this.customerRepo.findById(id);
		if(c.isPresent()) {
			this.customerRepo.deleteById(id);
		}
		else {
			throw new CustomerException(CustomerException.NotFoundException(id));
		}
		
	}

}

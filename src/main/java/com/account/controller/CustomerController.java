package com.account.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.account.exception.CustomerException;
import com.account.model.Customer;
import com.account.repository.CustomerRepo;
import com.account.service.CustomerService;
import com.account.service.CustomerServiceImpl;
@CrossOrigin
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRepo customerRepository;
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customer")
	public ResponseEntity<?> getAllCustomers(){
		List<Customer> customer=this.customerRepository.findAll();
		if(customer.size()>0) {
			return new ResponseEntity<List<Customer>>(customer,HttpStatus.OK);
		}
		else {
			return new ResponseEntity("No Customers Available", HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/customer")
	public ResponseEntity<?> addCustomer (@RequestBody Customer customer){
		try {
			this.customerService.createCustomer(customer);
			System.out.println(customer.toString());
			return new ResponseEntity(customer.getName()+" added successfully",HttpStatus.OK);
		}
		catch(ConstraintViolationException e) {
			System.out.println("Bye");
			return new ResponseEntity(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
		}
		catch(CustomerException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
		}
	}
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id ){
		try {
			this.customerRepository.deleteById(id);
			return new ResponseEntity(id+" Deleted Successfully",HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
	}

}

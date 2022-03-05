package com.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.account.model.Customer;
import com.account.repository.CustomerRepo;
@CrossOrigin
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRepo customerRepository;
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
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
		try {
			Customer save=this.customerRepository.save(customer);
			System.out.println(save.toString());
			return new ResponseEntity(save.getName()+" added successfully",HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

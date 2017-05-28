package com.anthonyang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anthonyang.domain.Customer;
import com.anthonyang.repository.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	CustomerRepository customerRepository;
	
	@Autowired
	public CustomerController(CustomerRepository customerRepository){
		this.customerRepository = customerRepository;
	}

	@RequestMapping("/")
	public Iterable<Customer> list(){
		return customerRepository.findAll();
	}
	
	@RequestMapping("/{id}")
	public Customer read(@PathVariable(value="id") long id){
		return customerRepository.findOne(id);
	}
	
}

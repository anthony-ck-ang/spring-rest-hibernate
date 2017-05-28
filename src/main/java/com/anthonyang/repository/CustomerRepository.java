package com.anthonyang.repository;

import org.springframework.data.repository.CrudRepository;

import com.anthonyang.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}

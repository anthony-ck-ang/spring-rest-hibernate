package com.anthonyang.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anthonyang.domain.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

	Transaction findFirstByOrderByPostedOnDesc();

	List<Transaction> findAllByOrderByPostedOnDesc();

	Transaction findBySlug(String slug);

}

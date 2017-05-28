package com.anthonyang.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anthonyang.domain.Transaction;
import com.anthonyang.repository.CustomerRepository;
import com.anthonyang.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	private TransactionRepository transactionRepository;
	private CustomerRepository customerRepository;
	
	@Autowired
	public TransactionServiceImpl(TransactionRepository transactionRepository, CustomerRepository customerRepository){
		this.transactionRepository = transactionRepository;
		this.customerRepository = customerRepository;
	}

	@Override
	public Iterable<Transaction> list() {
		return transactionRepository.findAll();
	}

	@Override
	public Transaction read(long id) {
		return transactionRepository.findOne(id);
	}

	@Override
	@Transactional
	public Transaction create(Transaction transaction) {
		// save the new customer
		customerRepository.save(transaction.getCustomer());
		return transactionRepository.save(transaction);
	}

	@Override
	public void delete(long id) {
		transactionRepository.delete(id);
	}

	@Override
	public Transaction update(long id,Transaction update) {
		Transaction transaction = transactionRepository.findOne(id);
		if( update.getTitle() != null ) {
			transaction.setTitle(update.getTitle());
		}
		return transactionRepository.save(transaction);
	}

}

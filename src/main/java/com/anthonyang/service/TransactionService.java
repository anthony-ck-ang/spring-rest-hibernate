package com.anthonyang.service;

import com.anthonyang.domain.Transaction;

public interface TransactionService {
	
	Iterable<Transaction> list();
	
	Transaction create(Transaction transaction);
	
	Transaction read(long id);
	
	Transaction update(long id, Transaction transaction);
	
	void delete(long id);
}

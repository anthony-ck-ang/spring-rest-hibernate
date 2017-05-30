package com.anthonyang.exception;

public class TransactionNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1226439803994500725L;

	public TransactionNotFoundException(String msg){
		super(msg);
	}
	
}

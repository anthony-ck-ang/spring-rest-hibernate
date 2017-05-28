package com.anthonyang.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.anthonyang.domain.Transaction;
import com.anthonyang.exception.PostNotFoundException;
import com.anthonyang.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

	private TransactionService transactionService;
	
	@Autowired
	public TransactionController(TransactionService postService){
		this.transactionService = postService;
	}
	
	@RequestMapping( value = "/", method = RequestMethod.GET )
	public Iterable<Transaction> list(){
		return transactionService.list();
	}
	
	@RequestMapping( value = "/", method = RequestMethod.POST )
	public Transaction create(@RequestBody Transaction post){
		return transactionService.create(post);
	}
	
	@RequestMapping( value = "/{id}", method = RequestMethod.GET )
	public Transaction read(@PathVariable(value="id") long id) throws PostNotFoundException {
		Transaction post = transactionService.read(id);
		if( post == null ){
			throw new PostNotFoundException("Transaction with id: " + id + " not found.");
		}
		return post;
	}
	
	@RequestMapping( value = "/{id}", method = RequestMethod.PUT )
	public Transaction update(@PathVariable(value="id") long id, @RequestBody Transaction transaction){
		return transactionService.update(id,transaction);
	}
	
	@RequestMapping( value = "/{id}", method = RequestMethod.DELETE )
	public void delete(@PathVariable(value="id") int id){
		transactionService.delete(id);
	}	
	
	@ExceptionHandler(PostNotFoundException.class)
	public void handlePostNotFound(PostNotFoundException exception, HttpServletResponse response) throws IOException{
		response.sendError( HttpStatus.NOT_FOUND.value(), exception.getMessage() );
	}
}

package com.ING.BankAccountKata.controller;


import java.math.BigDecimal;
import java.math.MathContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.ING.BankAccountKata.domain.Account;

import com.ING.BankAccountKata.exception.InvalidAmountException;
import com.ING.BankAccountKata.exception.ResourceNotFoundException;
import com.ING.BankAccountKata.repository.AccountServiceRepository;



@RestController
	
public class DepositController {
	
	
	
	
	
	  @Autowired
	  AccountServiceRepository repository;
	  @PostMapping("/addCustomer")
		public Account createUser(@RequestBody Account customer) {
			 
			 return this.repository.save(customer);
		}
	 @PutMapping("/deposit/{id}")
	 public void deposit(@RequestParam BigDecimal money,@PathVariable (value = "id") long Accountid) throws InvalidAmountException {
		 
		 Account customer = repository.findById(Accountid)
				 .orElseThrow(() -> new ResourceNotFoundException("customer not found for this id :: " + Accountid));
				
	        if ( money.signum()<1 ) {
	            throw new InvalidAmountException("veryless amont:: " + money);
	        }
	        
	        
	        BigDecimal oldamount=customer.getAmount();
	        BigDecimal newamount= oldamount.add(money);
	        
	        customer.setAmount(newamount);
	        repository.save(customer);
		
	 }
	 @PutMapping("/withdraw/{id}")
	 public void withdraw(@RequestParam BigDecimal money,@PathVariable (value = "id") long Accountid) throws InvalidAmountException {
		 
		 Account customer = repository.findById(Accountid)
				 .orElseThrow(() -> new ResourceNotFoundException("customer not found for this id :: " + Accountid));
				
	        if ( money.signum()>100000000 ) {
	            throw new InvalidAmountException("veryless amont:: " + money);
	        }
	        
	        
	        BigDecimal oldamount=customer.getAmount();
	        BigDecimal newamount= oldamount.subtract(oldamount);
	        
	        customer.setAmount(newamount);
	        repository.save(customer);
		
	 }}

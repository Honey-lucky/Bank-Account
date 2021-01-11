package com.ING.BankAccountKata.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class InvalidAmountException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public InvalidAmountException(String message) {
		super(message);
	}
	
	public InvalidAmountException(String message, Throwable throwable) {
		super(message, throwable);
	}
}

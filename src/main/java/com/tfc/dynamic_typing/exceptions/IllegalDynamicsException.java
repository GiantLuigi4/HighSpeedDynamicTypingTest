package com.tfc.dynamic_typing.exceptions;

public class IllegalDynamicsException extends RuntimeException {
	public IllegalDynamicsException() {
	}
	
	public IllegalDynamicsException(String message) {
		super(message);
	}
	
	public IllegalDynamicsException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public IllegalDynamicsException(Throwable cause) {
		super(cause);
	}
	
	public IllegalDynamicsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}

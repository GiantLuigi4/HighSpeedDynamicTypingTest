package com.tfc.dynamic_typing.exceptions;

public class IllegalDynamicArgumentException extends IllegalDynamicsException {
	public IllegalDynamicArgumentException() {
	}
	
	public IllegalDynamicArgumentException(String message) {
		super(message);
	}
	
	public IllegalDynamicArgumentException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public IllegalDynamicArgumentException(Throwable cause) {
		super(cause);
	}
	
	public IllegalDynamicArgumentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}

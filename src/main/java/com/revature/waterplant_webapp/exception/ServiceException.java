package com.revature.waterplant_webapp.exception;

public class ServiceException extends Exception {

	public ServiceException(String message) {
		super(message);
	}
	
	public ServiceException(String message, Throwable t) {
		super(message,t);
	}
}

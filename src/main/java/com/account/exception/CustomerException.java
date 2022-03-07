package com.account.exception;

public class CustomerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CustomerException(String message) {
		super(message);
	}
	public static String NotFoundException(String id) {
		return "Customer with "+id+ " not found";
	}
	public static String CustomerAlreadyExists() {
		return "Customer with given name already exists";
	}

}

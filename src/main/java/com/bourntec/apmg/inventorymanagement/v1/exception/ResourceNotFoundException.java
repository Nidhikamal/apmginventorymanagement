package com.bourntec.apmg.inventorymanagement.v1.exception;
/**
 * Customised exception class for handling resource not found exception
 * 
 * @author Srijini T.S
 *
 */
public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1069373043739450748L;

	public ResourceNotFoundException() {
		
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
	
	
}

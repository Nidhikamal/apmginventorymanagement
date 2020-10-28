package com.bourntec.apmg.inventorymanagement.v1.exception;

/**
 * Customized exception class for handling for Forbidden exceptions
 * 
 * @author Srijini T.S
 *
 */
public class ForbiddenException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1069373043739450748L;

	public ForbiddenException() {

	}

	public ForbiddenException(String message) {
		super(message);
	}

}

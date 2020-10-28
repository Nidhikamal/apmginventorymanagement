package com.bourntec.apmg.inventorymanagement.v1.exception;

import org.springframework.security.core.AuthenticationException;

public class UnAuthorizedException extends AuthenticationException {

	public UnAuthorizedException(String msg) {
		super(msg);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1069373043739450748L;

}

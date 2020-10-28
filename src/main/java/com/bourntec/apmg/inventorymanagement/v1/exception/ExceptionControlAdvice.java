package com.bourntec.apmg.inventorymanagement.v1.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Class for centralized management for Exception
 *************************************************
 * For every run time exception and custom exception that occurs in our service layer 
 * will be caught and handle through
 * this class by using the java  reflection
 *
 * @author Srijini T.S
 *
 */
@ControllerAdvice
public class ExceptionControlAdvice extends ResponseEntityExceptionHandler {
	/**
	 * Exception handler for handling the runtime exception.
	 * usually it is of type internal server error.
	 * @param ex
	 * @param request
	 * @return 
	 */
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<?> handleRunTimeException(Exception ex, final HttpServletRequest request) {
		ExceptionResponse response = new ExceptionResponse();
		response.setResponseMessage(ex.getMessage());
		response.setRequestURL(request.getRequestURI());
		response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<>(response,response.getHttpStatus());
	}
	
	/**
	 * Exception handler for handling the custom exception of resource not found
	 * that is found in service layer
	 * @param exception
	 * @param request
	 * @return
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> handleResourceNotFound(final ResourceNotFoundException exception,
			final HttpServletRequest request) {

		ExceptionResponse response = new ExceptionResponse();
		response.setResponseMessage(exception.getMessage());
		response.setRequestURL(request.getRequestURI());
		response.setErrorCode(HttpStatus.NOT_FOUND.value());
		response.setHttpStatus(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(response, response.getHttpStatus());
	}
	/**
	 * Exception handler for handling the custom exception of all Runtime Exceptions
	 * that is found in service layer
	 * @param exception
	 * @param request
	 * @return
	 */
	@ExceptionHandler(ForbiddenException.class)
	public ResponseEntity<Object> handleAccessDenied(final ForbiddenException exception,
			final HttpServletRequest request) {

		ExceptionResponse response = new ExceptionResponse();
		response.setResponseMessage(exception.getMessage());
		response.setRequestURL(request.getRequestURI());
		response.setErrorCode(HttpStatus.FORBIDDEN.value());
		response.setHttpStatus(HttpStatus.FORBIDDEN);
		return new ResponseEntity<>(response, response.getHttpStatus());
	}
	
	/**
	 * Exception handler for handling the custom exception of UnAuthorized Request
	 * that is found in service layer
	 * @param exception
	 * @param request
	 * @return
	 */
	@ExceptionHandler(UnAuthorizedException.class)
	public ResponseEntity<Object> handleUnauthorizedRequest(final UnAuthorizedException exception,
			final HttpServletRequest request) {

		ExceptionResponse response = new ExceptionResponse();
		response.setResponseMessage(exception.getMessage());
		response.setRequestURL(request.getRequestURI());
		response.setErrorCode(HttpStatus.UNAUTHORIZED.value());
		response.setHttpStatus(HttpStatus.UNAUTHORIZED);
		return new ResponseEntity<>(response, response.getHttpStatus());
	}

}

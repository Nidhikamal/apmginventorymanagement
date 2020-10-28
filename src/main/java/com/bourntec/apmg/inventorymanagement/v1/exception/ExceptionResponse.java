package com.bourntec.apmg.inventorymanagement.v1.exception;

import org.springframework.http.HttpStatus;
/**
 * class for customizing the exception response that thrown to user.
 * with the adequate information about the exception that cause..
 * 
 ************************************************************* 
 * @author Srijini T.S
 *
 */
public class ExceptionResponse {

	private String responseMessage;
	
	private String requestURL;
	
	private int errorCode;
	
	private HttpStatus httpStatus;
	
	/**
	 * Method for getting error code.
	 * @return
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * Method for setting the error code
	 * @param errorCode
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	/**
	 * Method for getting the response
	 * @return
	 */
	public String getResponseMessage() {
		return responseMessage;
	}

	/**
	 * Method for setting the responseMessage
	 * @param responseMessage
	 */
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	/**
	 * Method for getting request URL in which the exception
	 * is caused
	 * @return
	 */
	public String getRequestURL() {
		return requestURL;
	}
	
	/**
	 * Setting the request URL in the response at controller advice
	 * @param requestURL
	 */
	public void setRequestURL(String requestURL) {
		this.requestURL = requestURL;
	}
	
	/**
	 * Returing the HttpStatus in response Entity object
	 * @return
	 */
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	
	public ExceptionResponse() {
		
	}
	
	public ExceptionResponse(String responseMessage, String requestURL, HttpStatus httpStatus) {
		super();
		this.responseMessage = responseMessage;
		this.requestURL = requestURL;
	}
}

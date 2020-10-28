package com.bourntec.apmg.inventorymanagement.v1.exception;
/**
 * Enum class for creating custom error codes.
 * 
 * @author Srijini T.S
 *
 */
public enum ErrorCodes {

	USER_NOT_FOUND("The user is not found"),
	MEDIA_TYPE_NOT_SUPPORTED("Media Type Not Supported"),
	UN_AUTH_USER("UnAuthorized User"),
	ACCESS_DENIED("Access Denied"),
	MERCH_NOT_FOUND("The Merchant  is not found"),
	PAYMENTTERMS_NOT_FOUND("The Payment term  is not found"),
	BROKER_NOT_FOUND("The Broker  is not found"),
	PARCEL_NOT_FOUND("The Parel  is not found"),
	INCIDENT_NOT_FOUND("The Incident  is not found"),
	FAQ_NOT_FOUND("The FAq is not found"),
	VENDOR_NOT_FOUND("The vendor is not found"),
	CUSTOMER_NOT_FOUND("The customer is not found"), 
	SEARCH_FAILED("Search Failed"), 
	USE_NOT_FOUND("User not Found"),
	EXCEED_LIMIT("Maximum allowable pieces is "), 
	ITEM_NOT_FOUND("Item is not a finding. Please enter another finding."),
	LOCATION_NOT_FOUND("Location is not a found. Please enter another location.");

	private final String message;
	

	private ErrorCodes(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}

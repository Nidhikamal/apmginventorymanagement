package com.bourntec.apmg.inventorymanagement.v1.dto.response;

public class CodeClarityResponseDTO {
	
	private String clarityId;
	private String clarityName;
	private String responseMessage;
	
	
	public String getClarityId() {
		return clarityId;
	}
	public void setClarityId(String clarityId) {
		this.clarityId = clarityId;
	}
	public String getClarityName() {
		return clarityName;
	}
	public void setClarityName(String clarityName) {
		this.clarityName = clarityName;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
}

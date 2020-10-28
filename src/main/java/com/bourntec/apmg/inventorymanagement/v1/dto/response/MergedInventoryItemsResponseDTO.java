package com.bourntec.apmg.inventorymanagement.v1.dto.response;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.MergedInventoryItemsRequestDTO;

public class MergedInventoryItemsResponseDTO extends MergedInventoryItemsRequestDTO {
 
	private String responseMessage;
 
	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	public MergedInventoryItemsResponseDTO() {

	}
}

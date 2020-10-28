package com.bourntec.apmg.inventorymanagement.v1.dto.response; 
import com.bourntec.apmg.inventorymanagement.v1.dto.request.ConversionTableRequestDTO;


/**
 * DTO class for sending the response
 *  
 * @author Nince
 *
 */

public class ConversionTableResponseDTO extends ConversionTableRequestDTO {

	
	
	/**
	 * property that is used to set the message
	 * in service when a particular action carried out in there
	 * for eg : when a arrival is not fetched, showing the material codes is not retrieved
	 * @TODO need to remove when exception module is implemented
	 */
	private String responseMessage;

	
	

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	public ConversionTableResponseDTO() {

	}
}

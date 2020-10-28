package com.bourntec.apmg.inventorymanagement.v1.dto.response; 
import com.bourntec.apmg.inventorymanagement.v1.dto.request.MarketCodeRequestDTO;

//import javax.validation.constraints.NotNull;



/**
 * DTO class for sending the response
 *  
 * @author Nince
 *
 */

public class MarketCodeResponseDTO extends MarketCodeRequestDTO {

	
	
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
	
	public MarketCodeResponseDTO() {

	}
}

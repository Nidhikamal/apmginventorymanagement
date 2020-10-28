package com.bourntec.apmg.inventorymanagement.v1.dto.response; 
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryAlternateRequestDTO;

import lombok.Getter;
import lombok.Setter;




/**
 * DTO class for sending the response
 *  
 * @author babu V
 *
 */
@Getter
@Setter
public class InventoryAlternateResponseDTO extends InventoryAlternateRequestDTO{

	
	
	/**
	 * property that is used to set the message
	 * in service when a particular action carried out in there
	 * for eg : when a inventory1 is not fetched, showing the material codes is not retrieved
	 * @TODO need to remove when exception module is implementd
	 */
	private String responseMessage;

	
	

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	public InventoryAlternateResponseDTO() {

	}
}

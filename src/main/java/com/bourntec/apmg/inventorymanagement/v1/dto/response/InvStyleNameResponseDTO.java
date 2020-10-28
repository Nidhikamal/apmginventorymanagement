package com.bourntec.apmg.inventorymanagement.v1.dto.response; 
import com.bourntec.apmg.entity.InvStyleName;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InvStyleNameRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.Inventory1RequestDTO;

//import javax.validation.constraints.NotNull;



/**
 * DTO class for sending the response for StyleName
 *  
 * @author Vidya
 *
 */

public class InvStyleNameResponseDTO extends InvStyleNameRequestDTO{

	private String responseMessage;

	

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	public InvStyleNameResponseDTO() {

	}
}

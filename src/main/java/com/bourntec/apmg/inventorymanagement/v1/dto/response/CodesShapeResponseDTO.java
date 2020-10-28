package com.bourntec.apmg.inventorymanagement.v1.dto.response;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodesShapeRequestDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CodesShapeResponseDTO extends CodesShapeRequestDTO {
	/**
	 * property that is used to set the message in service when a particular action
	 * carried out in there for eg : when a user is not fetched, showing the user is
	 * not retrieved
	 * 
	 * @TODO need to remove when exception module is implementd
	 */
	private String responseMessage;

}

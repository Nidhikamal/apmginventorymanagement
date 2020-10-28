package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import com.bourntec.apmg.entity.InvStyleName;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * Class is used as a RequestDTO for  StyleName
 * 
 * @author vidya.p
 *
 */
@Getter
@Setter
public class InvStyleNameRequestDTO {
	private String styleId;
	private String styleName;

	
	public InvStyleName toModel(InvStyleNameRequestDTO invStyleNameRequestDTO) {
		// TODO Auto-generated method stub
		InvStyleName cl = new InvStyleName();
		cl.setStyleId(invStyleNameRequestDTO.getStyleId());
		cl.setStyleName(invStyleNameRequestDTO.getStyleName());
		return cl;
	}



}

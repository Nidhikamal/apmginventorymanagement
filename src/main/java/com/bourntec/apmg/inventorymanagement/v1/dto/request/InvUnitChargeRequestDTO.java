package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.InvUnitCharge;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * Class is used as a data transfer object for inv UnitCharge  
 * 
 * @author Amal Chandra N A
 *
 */

@Getter
@Setter
@Validated
public class InvUnitChargeRequestDTO {

	
	private String unitCharge;
	private String unitDesc;
	
	public InvUnitCharge toModel(InvUnitChargeRequestDTO invUnitChargeRequestDTO) {
		InvUnitCharge invUnitcharge = new InvUnitCharge();
		
		try {
			invUnitcharge.setUnitCharge(invUnitChargeRequestDTO.getUnitCharge());
			invUnitcharge.setUnitDesc(invUnitChargeRequestDTO.getUnitDesc());
			
		} catch (Exception e) {
            e.printStackTrace();
		}
		return invUnitcharge;

	}
	
}

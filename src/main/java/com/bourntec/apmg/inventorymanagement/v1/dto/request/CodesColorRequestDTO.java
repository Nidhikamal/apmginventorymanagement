package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.CodesColor;

/**
 * 
 * Class is used as a data transfer object for materail codes 
 * 
 * @author Amal Chandra N A
 *
 */
@Validated
public class CodesColorRequestDTO {

	
	private String colorId;
	

	private String colorName;
	private String unitCharge;
	
	
	public CodesColor toModel(CodesColorRequestDTO colorCodesRequestDTO) {
		CodesColor colorCodes = new CodesColor();
		
		try {
			colorCodes.setColorId(colorCodesRequestDTO.getColorId());
			colorCodes.setColorName(colorCodesRequestDTO.getColorName());
			colorCodes.setUnitCharge(colorCodesRequestDTO.getUnitCharge());
			
		} catch (Exception e) {
            e.printStackTrace();
		}
		return colorCodes;

	}


	public String getColorId() {
		return colorId;
	}


	public String getColorName() {
		return colorName;
	}


	public String getUnitCharge() {
		return unitCharge;
	}


	public void setColorId(String colorId) {
		this.colorId = colorId;
	}


	public void setColorName(String colorName) {
		this.colorName = colorName;
	}


	public void setUnitCharge(String unitCharge) {
		this.unitCharge = unitCharge;
	}

	
}

package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.TypeData;


/**
 * 
 * Class is used as a data transfer object for Type data
 * 
 * @author Amal Chandra N A
 *
 */
@Validated
public class TypeDataRequestDTO {

	
	private String typeCode;
	private String typeName;	
	private String locationCode;
	private String unitCharge;
	private String displayWeb;
	private String category;
	private String typeImage;
	
	
	public TypeData toModel(TypeDataRequestDTO typeDataRequestDTO) {
		TypeData typeData = new TypeData();
		
		try {
			typeData.setTypeCode(typeDataRequestDTO.getTypeCode());
			typeData.setTypeName(typeDataRequestDTO.getTypeName());
			typeData.setLocationCode(typeDataRequestDTO.getLocationCode());
			typeData.setUnitCharge(typeDataRequestDTO.getUnitCharge());
			typeData.setCategory(typeDataRequestDTO.getCategory());
			typeData.setDisplayWeb(typeDataRequestDTO.getDisplayWeb());
			typeData.setTypeImage(typeDataRequestDTO.getTypeImage());
			
		} catch (Exception e) {
            e.printStackTrace();
		}
		return typeData;

	}


	


	public String getUnitCharge() {
		return unitCharge;
	}


	


	public void setUnitCharge(String unitCharge) {
		this.unitCharge = unitCharge;
	}


	





	public String getTypeCode() {
		return typeCode;
	}





	public String getTypeName() {
		return typeName;
	}





	public String getLocationCode() {
		return locationCode;
	}





	public String getDisplayWeb() {
		return displayWeb;
	}





	public String getCategory() {
		return category;
	}





	public String getTypeImage() {
		return typeImage;
	}





	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}





	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}





	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}





	public void setDisplayWeb(String displayWeb) {
		this.displayWeb = displayWeb;
	}





	public void setCategory(String category) {
		this.category = category;
	}





	public void setTypeImage(String typeImage) {
		this.typeImage = typeImage;
	}

	
}

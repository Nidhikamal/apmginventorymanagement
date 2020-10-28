package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.CodesMaterial;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * Class is used as a data transfer object for materail codes 
 * 
 * @author Amal Chandra N A
 *
 */
@Validated
@Getter
@Setter
public class CodesMaterailRequestDTO {

	
	private String materialId;
	private String materialName;
	
	
	public CodesMaterial toModel(CodesMaterailRequestDTO materialCodesRequestDTO) {
		CodesMaterial materialCodes = new CodesMaterial();
		
		try {
			materialCodes.setMaterialId(materialCodesRequestDTO.getMaterialId());
			materialCodes.setMaterialName(materialCodesRequestDTO.getMaterialName());
			
		} catch (Exception e) {
            e.printStackTrace();
		}
		return materialCodes;

	}


	
	
}

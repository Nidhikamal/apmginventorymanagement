package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.ConversionTable;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * Class is used as a data transfer object for Conversion Table 
 * 
 * @author Nince
 *
 */

@Getter
@Setter
@Validated
public class ConversionTableRequestDTO {

	
	private String karatValue;
	private Double convAmt;
	private String locationCode;
	
	public ConversionTable toModel(ConversionTableRequestDTO conversionTableRequestDTO) {
		ConversionTable conversionTable = new ConversionTable();
		
		try {
			if(conversionTableRequestDTO.getKaratValue() != null && !conversionTableRequestDTO.getKaratValue().isEmpty()) {
				conversionTable.setKaratValue(conversionTableRequestDTO.getKaratValue());
			}
			if(conversionTableRequestDTO.getConvAmt() != null) {
				conversionTable.setConvAmt(conversionTableRequestDTO.getConvAmt());
			}
			if(conversionTableRequestDTO.getLocationCode() != null && !conversionTableRequestDTO.getLocationCode().isEmpty()) {
				conversionTable.setLocationCode(conversionTableRequestDTO.getLocationCode());
			}
		} catch (Exception e) {
            e.printStackTrace();
		}
		return conversionTable;

	}
	
}

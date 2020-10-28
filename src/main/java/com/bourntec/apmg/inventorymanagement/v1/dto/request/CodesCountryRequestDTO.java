package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import com.bourntec.apmg.entity.CodesCountry;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CodesCountryRequestDTO {
	private String countryCode;
	private String countryName;

	
	public CodesCountry toModel(CodesCountryRequestDTO codesCountryRequestDTO) {
		// TODO Auto-generated method stub
		CodesCountry codesCountry = new CodesCountry();
		if(codesCountryRequestDTO.getCountryCode() != null && !codesCountryRequestDTO.getCountryCode().isEmpty()) {
			codesCountry.setCountryCode(codesCountryRequestDTO.getCountryCode());
		}
		if(codesCountryRequestDTO.getCountryName() != null && !codesCountryRequestDTO.getCountryName().isEmpty()){
			codesCountry.setCountryName(codesCountryRequestDTO.getCountryName());
		}
		return codesCountry;
	}
}

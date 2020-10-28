package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.CountrySetup;

/**
 * 
 * Class is used as a data transfer object for materail codes 
 * 
 * @author Amal Chandra N A
 *
 */
@Validated
public class CountrySetupRequestDTO {

	
	private String countryCode;
	private String countryName;
	
	
	public CountrySetup toModel(CountrySetupRequestDTO countrySetupRequestDTO) {
		CountrySetup countrySetup = new CountrySetup();
		
		try {
			countrySetup.setCountryCode(countrySetupRequestDTO.getCountryCode());
			countrySetup.setCountryName(countrySetupRequestDTO.getCountryName());
			
		} catch (Exception e) {
            e.printStackTrace();
		}
		return countrySetup;

	}


	public String getCountryCode() {
		return countryCode;
	}


	public String getCountryName() {
		return countryName;
	}


	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}


	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}


	
}

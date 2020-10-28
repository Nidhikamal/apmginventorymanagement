package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.CountrySetup;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CountrySetupRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CountrySetupResponseDTO;

public interface CountrySetupService {
	CountrySetupResponseDTO findCountrySetupById(String id);

	List<CountrySetup> findCountrySetup();

	CountrySetupResponseDTO updateCountrySetupById(String id, CountrySetupRequestDTO countrySetupReqDTO);

	CountrySetupResponseDTO saveCountrySetup(CountrySetupRequestDTO countrySetupReqDTO);

	CountrySetupResponseDTO delete(String id);

	List<CountrySetupResponseDTO> search(CountrySetupRequestDTO shapeRequestDTO) throws Exception;

}

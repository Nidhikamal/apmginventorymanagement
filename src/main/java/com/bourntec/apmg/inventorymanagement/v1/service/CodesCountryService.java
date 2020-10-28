package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodesCountryRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodesCountryResponseDTO;
/**
 * Service interface for CountryCode
 * @author Nince
 *
 */
public interface CodesCountryService {

	CodesCountryResponseDTO getCodesCountryByCountryCode(String countryCode);

	List<CodesCountryResponseDTO> findAllCodesCountry();

	CodesCountryResponseDTO saveCodesCountry(CodesCountryRequestDTO dataReq);

	CodesCountryResponseDTO updateCodesCountry(String countryCode, CodesCountryRequestDTO dataReq);

	List<CodesCountryResponseDTO> findCodesCountryByCriteria(CodesCountryRequestDTO dataReq);

	CodesCountryResponseDTO deleteCodesCountryByCountryCode(String countryCode);

}

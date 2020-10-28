package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodesShapeRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodesCountryRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodesCountryResponseDTO;

public interface StoneOriginService {

	List<CodesCountryResponseDTO> findAllCodesCountry() throws Exception;

	CodesCountryResponseDTO findcodeCountryById(String countryCode) throws Exception;

	CodesCountryResponseDTO savecodeCountry(CodesCountryRequestDTO codesCountryRequestDTO) throws Exception;

	CodesCountryResponseDTO updateStoneOrigin(String countryCode, CodesCountryRequestDTO codesCountryRequestDTO) throws Exception;

	CodesCountryResponseDTO delete(String id) throws Exception;

	List<CodesCountryResponseDTO> search(CodesCountryRequestDTO shapeRequestDTO) throws Exception;


}

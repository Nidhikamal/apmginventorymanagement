package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.AdditionalOrderDataRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.AdditionalOrderDataResponseDTO;

public interface AdditionalOrderDataService {

	List<AdditionalOrderDataResponseDTO> findAllSizeMainatinence() throws Exception;

	AdditionalOrderDataResponseDTO findSizeMainatinenceById(Long id) throws Exception;

	AdditionalOrderDataResponseDTO saveSizeMaintainence(AdditionalOrderDataRequestDTO addtionalOrderDataRequestDTO) throws Exception;
	
	AdditionalOrderDataResponseDTO updateSizeMaintainence(Long id,
			AdditionalOrderDataRequestDTO addtionalOrderDataRequestDTO) throws Exception;

	AdditionalOrderDataResponseDTO deleteShapeMaintance(Long id) throws Exception;

	List<AdditionalOrderDataResponseDTO> searchSizeMaintance(AdditionalOrderDataRequestDTO sizeRequestDTO) throws Exception;
	
	
}

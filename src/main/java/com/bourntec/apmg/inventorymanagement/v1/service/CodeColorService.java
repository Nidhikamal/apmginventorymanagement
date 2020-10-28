package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.CodesColor;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodesColorRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodesColorResponseDTO;

public interface CodeColorService {
	List<CodesColor> findAllColorCodes() throws Exception;

	CodesColorResponseDTO findColorCodesById(String id) throws Exception;

	CodesColorResponseDTO saveColorCodes(CodesColorRequestDTO codesColorReqDTO) throws Exception;

	CodesColorResponseDTO updateColorCodesById(String id, CodesColorRequestDTO codesColorReqDTO) throws Exception;

	CodesColorResponseDTO delete(String id) throws Exception;

	List<CodesColorResponseDTO> search(CodesColorRequestDTO requestDTO) throws Exception;
}

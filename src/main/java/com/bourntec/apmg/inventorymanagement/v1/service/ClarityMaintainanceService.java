package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodeClarityRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodeClarityResponseDTO;

public interface ClarityMaintainanceService {

	CodeClarityResponseDTO savecodeClarity(CodeClarityRequestDTO codesCountryRequestDTO) throws Exception;

	CodeClarityResponseDTO findCodeClarityById(String clarityId) throws Exception;

	List<CodeClarityResponseDTO> findAllCodeClarity() throws Exception;

	CodeClarityResponseDTO updateclaritymaintainance(String clarityId, CodeClarityRequestDTO codeClarityRequestDTO)
			throws Exception;

	CodeClarityResponseDTO delete(String id) throws Exception;

	List<CodeClarityResponseDTO> search(CodeClarityRequestDTO shapeRequestDTO) throws Exception;

}

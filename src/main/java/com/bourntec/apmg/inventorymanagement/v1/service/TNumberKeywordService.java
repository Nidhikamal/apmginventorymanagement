package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.TNumberKeywordRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.TNumberKeywordResponseDTO;

public interface TNumberKeywordService {

	List<TNumberKeywordResponseDTO> findAllTNumberKeywords() throws Exception;

	TNumberKeywordResponseDTO getTNumberKeywordById(Long id) throws Exception;

	TNumberKeywordResponseDTO saveTNumberKeywords(TNumberKeywordRequestDTO tNumberKeywordRequestDTO) throws Exception;

	List<TNumberKeywordResponseDTO> findTNumberKeywordByCriteria(TNumberKeywordRequestDTO tNumberKeywordRequestDTO)
			throws Exception;

	TNumberKeywordResponseDTO updateTNumberKeyword(Long id, TNumberKeywordRequestDTO tNumberKeywordRequestDTO)
			throws Exception;

	TNumberKeywordResponseDTO deleteTNumberKeywordById(Long id) throws Exception;

}

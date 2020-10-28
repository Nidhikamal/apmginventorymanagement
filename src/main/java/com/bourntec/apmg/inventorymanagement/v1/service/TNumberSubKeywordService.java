package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.TNumberSubKeywordRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.TNumberSubKeywordResponseDTO;

public interface TNumberSubKeywordService {
	List<TNumberSubKeywordResponseDTO> findAllTNumberSubKeywords() throws Exception;

	TNumberSubKeywordResponseDTO getTNumberSubKeywordById(Long id) throws Exception;

	TNumberSubKeywordResponseDTO saveTNumberSubKeywords(TNumberSubKeywordRequestDTO tNumberSubKeywordRequestDTO)
			throws Exception;

	List<TNumberSubKeywordResponseDTO> findTNumberSubKeywordByCriteria(
			TNumberSubKeywordRequestDTO tNumberSubKeywordRequestDTO) throws Exception;

	TNumberSubKeywordResponseDTO updateTNumberSubKeyword(Long id, TNumberSubKeywordRequestDTO tNumberSubKeywordRequestDTO)
			throws Exception;

	TNumberSubKeywordResponseDTO deleteTNumberSubKeywordById(Long id) throws Exception;

}

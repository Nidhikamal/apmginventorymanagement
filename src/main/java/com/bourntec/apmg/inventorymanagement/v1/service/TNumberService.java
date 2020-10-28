package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.TNumberRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.TNumberResponseDTO;

public interface TNumberService {

	List<TNumberResponseDTO> findAllTNumbers() throws Exception;

	TNumberResponseDTO getTNumberById(Long id) throws Exception;

	TNumberResponseDTO saveTNumbers(TNumberRequestDTO tNumberRequestDTO) throws Exception;

	List<TNumberResponseDTO> findTNumberByCriteria(TNumberRequestDTO tNumberRequestDTO)
			throws Exception;

	TNumberResponseDTO updateTNumber(Long id, TNumberRequestDTO tNumberRequestDTO)
			throws Exception;

	TNumberResponseDTO deleteTNumberById(Long id) throws Exception;

}

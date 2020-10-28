package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.TNumberHistoryRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.TNumberHistoryResponseDTO;

public interface TNumberHistoryService {

	List<TNumberHistoryResponseDTO> findAllTNumberHistorys() throws Exception;

	TNumberHistoryResponseDTO getTNumberHistoryById(Long id) throws Exception;

	TNumberHistoryResponseDTO saveTNumberHistorys(TNumberHistoryRequestDTO tNumberKeywordRequestDTO) throws Exception;

	List<TNumberHistoryResponseDTO> findTNumberHistoryByCriteria(TNumberHistoryRequestDTO tNumberKeywordRequestDTO)
			throws Exception;

	TNumberHistoryResponseDTO updateTNumberHistory(Long id, TNumberHistoryRequestDTO tNumberKeywordRequestDTO)
			throws Exception;

	TNumberHistoryResponseDTO deleteTNumberHistoryById(Long id) throws Exception;

}

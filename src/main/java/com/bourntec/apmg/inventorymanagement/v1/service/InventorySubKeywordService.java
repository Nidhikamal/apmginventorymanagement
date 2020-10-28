package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventorySubKeywordRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventorySubKeywordResponseDTO;
/**
 * Service interface for InventorySubKeyword
 * @author Nince
 *
 */
public interface InventorySubKeywordService {

	InventorySubKeywordResponseDTO getInventorySubKeywordById(Long id);

	List<InventorySubKeywordResponseDTO> findAllInventorySubKeyword();

	InventorySubKeywordResponseDTO saveInventorySubKeyword(InventorySubKeywordRequestDTO dataReq);

	InventorySubKeywordResponseDTO updateInventorySubKeyword(Long id, InventorySubKeywordRequestDTO dataReq);

	List<InventorySubKeywordResponseDTO> findInventorySubKeywordByCriteria(InventorySubKeywordRequestDTO dataReq);

	InventorySubKeywordResponseDTO deleteInventorySubKeywordById(Long id);

}

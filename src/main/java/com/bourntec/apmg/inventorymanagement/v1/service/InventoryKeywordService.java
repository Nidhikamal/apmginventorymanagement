package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryKeywordRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryKeywordResponseDTO;
/**
 * Service interface for InventoryKeyword
 * @author Nince
 *
 */
public interface InventoryKeywordService {

	InventoryKeywordResponseDTO getInventoryKeywordById(Long id);

	List<InventoryKeywordResponseDTO> findAllInventoryKeyword();

	InventoryKeywordResponseDTO saveInventoryKeyword(InventoryKeywordRequestDTO dataReq);

	InventoryKeywordResponseDTO updateInventoryKeyword(Long id, InventoryKeywordRequestDTO dataReq);

	List<InventoryKeywordResponseDTO> findInventoryKeywordByCriteria(InventoryKeywordRequestDTO dataReq);

	InventoryKeywordResponseDTO deleteInventoryKeywordById(Long id);

}

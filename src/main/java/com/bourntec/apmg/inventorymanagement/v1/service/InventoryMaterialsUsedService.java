package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.InventoryMaterialsUsed;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryMaterialsRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryMaterialsResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.TypeDataResponseDTO;

/**
 * @author Srijini
 *
 */
public interface InventoryMaterialsUsedService {
	InventoryMaterialsResponseDTO saveMamaterial(List<InventoryMaterialsRequestDTO> invReqDTOList)
			throws Exception;

	InventoryMaterialsResponseDTO updateInventoryMaterials(
			List<InventoryMaterialsRequestDTO> lstinventoryMaterialsRequestDTO, String itemCode) throws Exception;

	InventoryMaterialsResponseDTO delete(Long id) throws Exception;
	List<InventoryMaterialsUsed> fetchAllInventoryMaterialsUsedByItemcode(String itemCode);
}

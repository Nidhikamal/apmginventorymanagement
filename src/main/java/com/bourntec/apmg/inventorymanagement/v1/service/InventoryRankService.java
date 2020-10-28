package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.InventoryRank;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryRankRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryRankResponseDTO;

public interface InventoryRankService {
	InventoryRankResponseDTO findInvRankById(String id) throws Exception;

	List<InventoryRank> findAllInvRanks() throws Exception;

	InventoryRankResponseDTO updateInvRankById(String id, InventoryRankRequestDTO invRankReqDTO) throws Exception;

	InventoryRankResponseDTO saveInvRanks(InventoryRankRequestDTO invRankReqDTO) throws Exception;

	InventoryRankResponseDTO delete(String id) throws Exception;

	List<InventoryRankResponseDTO> search(InventoryRankRequestDTO shapeRequestDTO) throws Exception;
}

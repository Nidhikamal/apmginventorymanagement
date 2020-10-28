package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryMarketRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryMarketResponseDTO;
/**
 * Service interface for InventoryMarket
 * @author Nince
 *
 */
public interface InventoryMarketService {

	InventoryMarketResponseDTO getInventoryMarketById(Long id);

	List<InventoryMarketResponseDTO> findAllInventoryMarket();

	InventoryMarketResponseDTO saveInventoryMarket(InventoryMarketRequestDTO dataReq);

	InventoryMarketResponseDTO updateInventoryMarket(Long id, InventoryMarketRequestDTO dataReq);

	List<InventoryMarketResponseDTO> findInventoryMarketByCriteria(InventoryMarketRequestDTO dataReq);

	InventoryMarketResponseDTO deleteInventoryMarketById(Long id);

}

package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.InventoryPriceHistory;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryPriceHistoryRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryPriceHistoryResponseDTO;

public interface InventoryPriceHistoryService {

	List<InventoryPriceHistory> getAllPriceHistoryofItem(String itemCode) throws Exception;

	InventoryPriceHistoryResponseDTO saveInvetoryPrice(InventoryPriceHistoryRequestDTO invPricehistory)
			throws Exception;

}

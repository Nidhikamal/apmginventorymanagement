package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.InventoryStockHistory;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryStockHistoryRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryStockHistoryResponseDTO;

public interface InventoryStockHistoryService {
	InventoryStockHistoryResponseDTO findInventoryStockHistoryById(String id) throws Exception;

	List<InventoryStockHistory> findAllInventoryStockHistory() throws Exception;

	InventoryStockHistoryResponseDTO updateInventoryStockHistory(String id, InventoryStockHistoryRequestDTO invRankReqDTO) throws Exception;

	InventoryStockHistoryResponseDTO saveInventoryStockHistory(InventoryStockHistoryRequestDTO invRankReqDTO) throws Exception;

	InventoryStockHistoryResponseDTO delete(String id) throws Exception;

	List<InventoryStockHistory> search(InventoryStockHistoryRequestDTO shapeRequestDTO) throws Exception;

}

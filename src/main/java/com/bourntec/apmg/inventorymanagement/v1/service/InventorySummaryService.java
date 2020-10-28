package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryFindingsRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventorySummaryRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryFindingsResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventorySummaryResponseDTO;

public interface InventorySummaryService {

	InventorySummaryResponseDTO getItemSummary(String itemCode) throws Exception;


	InventorySummaryResponseDTO saveSummary(InventorySummaryRequestDTO invReqDTO) throws Exception;


	InventorySummaryResponseDTO updateSummary(InventorySummaryRequestDTO invReqDTO, String itemCode) throws Exception;



}
